package com.example.core_data.local.localRepository

import android.content.Context
import android.util.Log
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
        Log.d("agjndkhjgbdghb",course.toString())
        dao.saveCourse(course)
        Log.d("agjndkhjgbdghb",getCourseById(course.id).toString())
        return
    }

    override suspend fun saveCourseByApi(course: CoursesEntity,id:Int) {
        var courseLocal = getCourseById(id)
        Log.d("agjndkhjgbdghb",courseLocal.toString())
        if(courseLocal?.hasLike !=null && courseLocal.hasLike){
            dao.updateCourseExceptLike(
                id = course.id,
                title = course.title,
                text = course.text,
                price = course.price,
                rate = course.rate,
                startDate = course.startDate,
                publishDate = course.publishDate
            )
        }else{
            dao.saveCourse(course)
        }
    }

    override suspend fun getCourseById(id:Int): CoursesEntity? {
        return dao.getCourseById(id)
    }

    override suspend fun saveUser(user: UserEntity) {
        dao.saveUser(user)
    }

    override suspend fun getUser(): UserEntity {
        return dao.getUser()
    }

}