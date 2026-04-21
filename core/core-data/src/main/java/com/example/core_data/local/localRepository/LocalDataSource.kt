package com.example.core_data.local.localRepository

import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

interface LocalDataSource {
    suspend fun getAllCourses(offset: Int, pageSet: Int): List<CoursesEntity>
    suspend fun getCharacterByLike(offset: Int, pageSet: Int): List<CoursesEntity>
    suspend fun saveCourse(course: CoursesEntity)
    suspend fun saveUser(user: UserEntity)
    suspend fun getUser(): UserEntity
}