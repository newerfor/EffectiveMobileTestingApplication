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

    override suspend fun getAllCourses(): List<CoursesDomainModel> {
        val result = remoteDataSource.getCoursesRemote()
        return result.courses.map { course ->
            mapper.mapModelToDomainCourse(course, course.id % 3)
        }
    }

    override suspend fun deleteCourses(courses: CoursesDomainModel) {
        localDataSource.deleteCourse(mapper.mapDomainToEntityCourse(courses))
    }

    override suspend fun getCoursesByLike(): List<CoursesDomainModel> {
        return localDataSource.getLikedCourses().map { course ->
            mapper.mapEntityToDomainCourse(course)
        }
    }

    override suspend fun saveCourses(courses: CoursesDomainModel) {
        localDataSource.saveCourse(mapper.mapDomainToEntityCourse(courses))
    }

    override suspend fun getCoursesById(id: Int): CoursesDomainModel? {
        val apiResult = remoteDataSource.getCoursesRemote()
        return apiResult.courses.find { it.id == id }?.let {

            mapper.mapModelToDomainCourse(
                it,
                it.id % 3
            )
        }
    }
}