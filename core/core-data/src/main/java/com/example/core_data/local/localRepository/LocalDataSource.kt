package com.example.core_data.local.localRepository

import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

interface LocalDataSource {
    suspend fun getLikedCourses(): List<CoursesEntity>
    suspend fun saveCourse(course: CoursesEntity)
    suspend fun deleteCourse(course: CoursesEntity)
    suspend fun saveUser(user: UserEntity)
    suspend fun getUser(): UserEntity
}