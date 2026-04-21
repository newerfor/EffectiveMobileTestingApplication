package com.example.core_data

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

    override suspend fun getApiCourses(offset:Int,pageSet:Int,dataBaseSize:Int): List<CoursesDomainModel> {
        val apiResult = remoteDataSource.getCoursesRemote()
        if(apiResult.courses.size>dataBaseSize){
            if(apiResult.courses.size>=pageSet){
                apiResult.courses.take(pageSet).forEach { course->
                    localDataSource.saveCourse(mapper.mapModelToEntityCourse(course))
                }
                saveCourseBatch(apiResult.courses.drop(pageSet))
            }else{
                apiResult.courses.forEach {course->
                    localDataSource.saveCourse(mapper.mapModelToEntityCourse(course))
                }
            }
            return localDataSource.getAllCourses(offset=offset,pageSet=pageSet).map {course->
                mapper.mapEntityToDomainCourse(course)
            }
        }else{
            throw RuntimeException("Данные пусты")
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
        return localDataSource.getAllCourses(offset=offset,pageSet=pageSet).map {course->
            mapper.mapEntityToDomainCourse(course)
        }
    }
    fun saveCourseBatch(course: List<CourseModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            course.forEach { course ->
                localDataSource.saveCourse(mapper.mapModelToEntityCourse(course))
            }
        }
    }
}