package com.example.core_data

import android.util.Log
import com.example.core_data.local.localRepository.LocalDataSource
import com.example.core_data.mapper.Mapper
import com.example.core_data.remote.model.CourseModel
import com.example.core_data.remote.remoteRepository.RemoteDataSource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_domain.repository.CoursesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) : CoursesRepository {
    override suspend fun getUserInfo(): UserInfoDomainModel {
        return mapper.mapEntityToDomainUser(localDataSource.getUser())
    }

    override suspend fun saveUserInfo(user: UserInfoDomainModel) {
        localDataSource.saveUser(mapper.mapDomainToEntityUser(user))
    }

    override suspend fun getApiCourses(
        offset: Int,
        pageSet: Int,
        dataBaseSize: Int
    ): List<CoursesDomainModel> {
        return try {
            // Пытаемся получить данные из API
            val apiResult = remoteDataSource.getCoursesRemote()

            // Проверяем размер полученных данных
            if (apiResult.courses.size <= dataBaseSize) {
                Log.d("Repository", "API вернул ${apiResult.courses.size} курсов, а в БД уже $dataBaseSize → данных нет")
                throw RuntimeException("Данные пусты")
            }

            // Данные из API есть и они новые
            Log.d("Repository", "API вернул ${apiResult.courses.size} курсов, в БД было $dataBaseSize")

            if (apiResult.courses.size >= pageSet) {
                // Сохраняем первые pageSet курсов синхронно
                apiResult.courses.take(pageSet).forEach { course ->
                    localDataSource.saveCourseByApi(mapper.mapModelToEntityCourse(course),course.id)
                }
                // Остальные сохраняем асинхронно
                saveCourseBatch(apiResult.courses.drop(pageSet))
            } else {
                // Если API вернул меньше, чем pageSet, сохраняем все
                apiResult.courses.forEach { course ->
                    localDataSource.saveCourseByApi(mapper.mapModelToEntityCourse(course),course.id)
                }
            }

            // Возвращаем сохранённые данные из БД
            localDataSource.getAllCourses(offset = offset, pageSet = pageSet)
                .map { mapper.mapEntityToDomainCourse(it) }

        } catch (e: Exception) {
            // При любой ошибке API (нет интернета, ошибка сервера, "Данные пусты")
            // пробуем взять из локальной БД
            Log.e("Repository", "Ошибка API: ${e.message}, пробуем взять из БД")

            val dbCourses = localDataSource.getAllCourses(offset = offset, pageSet = pageSet)
                .map { mapper.mapEntityToDomainCourse(it) }

            if (dbCourses.isEmpty()) {
                throw RuntimeException("Нет данных ни в API, ни в БД")
            }

            dbCourses
        }
    }

    override suspend fun getCoursesByLike(offset:Int,pageSet:Int): List<CoursesDomainModel> {
        return localDataSource.getCharacterByLike(offset=offset,pageSet=pageSet).map {course->
            mapper.mapEntityToDomainCourse(course)
        }
    }

    override suspend fun saveCourses(courses: CoursesDomainModel) {
        localDataSource.saveCourse(mapper.mapDomainToEntityCourse(courses))
    }

    override suspend fun getCoursesByDataBase(
        offset: Int,
        pageSet: Int
    ): List<CoursesDomainModel> {
        var currentPageSet = pageSet
        Log.d("Pagination_DB", "=== getCoursesByDataBase вызван ===")
        Log.d("Pagination_DB", "Запрошенный offset: $offset")
        Log.d("Pagination_DB", "Запрошенный pageSet: $pageSet")

        while (currentPageSet > 0) {
            try {
                Log.d("Pagination_DB", "Попытка #${pageSet - currentPageSet + 1}: пробуем currentPageSet=$currentPageSet")

                val result = localDataSource.getAllCourses(
                    offset = offset,
                    pageSet = currentPageSet
                ).map { course ->
                    mapper.mapEntityToDomainCourse(course)
                }

                Log.d("Pagination_DB", "Результат из БД: получено ${result.size} элементов")

                if (result.isNotEmpty()) {
                    Log.d("Pagination_DB", "✅ Успех! Возвращаем ${result.size} элементов")
                    result.forEachIndexed { index, course ->
                        Log.d("Pagination_DB", "  [$index] id=${course.id}, title=${course.title}")
                    }
                    return result
                }

                Log.d("Pagination_DB", "⚠️ Результат пустой, уменьшаем currentPageSet с $currentPageSet до ${currentPageSet - 1}")
                currentPageSet--

            } catch (e: Exception) {
                Log.e("Pagination_DB", "❌ Ошибка при запросе с currentPageSet=$currentPageSet", e)
                currentPageSet--
                Log.d("Pagination_DB", "Уменьшаем currentPageSet до $currentPageSet из-за ошибки")
            }
        }

        Log.d("Pagination_DB", "🏁 Все попытки исчерпаны (currentPageSet=0), возвращаем пустой список")
        return emptyList()
    }

    override suspend fun getCoursesById(id:Int): CoursesDomainModel {
        val result = localDataSource.getCourseById(id)
        return if(result!=null){
           mapper.mapEntityToDomainCourse(result)
        }else{
            throw RuntimeException("Данные пусты")
        }
    }

    fun saveCourseBatch(course: List<CourseModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            course.forEach { course ->
                localDataSource.saveCourseByApi(mapper.mapModelToEntityCourse(course),course.id)
            }
        }
    }
}