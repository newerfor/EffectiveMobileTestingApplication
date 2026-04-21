package com.example.core_domain.repository

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel

interface CoursesRepository {
    suspend fun getUserInfo():UserInfoDomainModel
    suspend fun saveUserInfo(user: UserInfoDomainModel)
    suspend fun getApiCourses(offset:Int,pageSet:Int,dataBaseSize:Int):List<CoursesDomainModel>
    suspend fun getCoursesByLike(offset:Int,pageSet:Int):List<CoursesDomainModel>
    suspend fun saveCourses(courses: CoursesDomainModel)
    suspend fun getCoursesByDataBase(offset:Int,pageSet:Int):List<CoursesDomainModel>
}