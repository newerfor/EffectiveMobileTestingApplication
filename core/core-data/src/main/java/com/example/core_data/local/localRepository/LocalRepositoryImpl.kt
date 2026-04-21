package com.example.core_data.local.localRepository

import android.content.Context
import com.example.core_data.local.dao.CoursesDao
import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

class LocalRepositoryImpl(
    private val dao: CoursesDao,
):LocalDataSource{
    override suspend fun getAllCourses(offset: Int, pageSet: Int): List<CoursesEntity> {
        return dao.getAllCourses(offset=offset,pageSet=pageSet)
    }

    override suspend fun getCharacterByLike(offset: Int, pageSet: Int): List<CoursesEntity> {
        return dao.getCoursesByLike(offset, pageSet)
    }

    override suspend fun saveCourse(course: CoursesEntity) {
        return dao.saveCourse(course)
    }

    override suspend fun saveUser(user: UserEntity) {
        dao.saveUser(user)
    }

    override suspend fun getUser(): UserEntity {
        return dao.getUser()
    }

}