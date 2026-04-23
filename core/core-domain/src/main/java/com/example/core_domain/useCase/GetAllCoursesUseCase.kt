package com.example.core_domain.useCase

import android.util.Log
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository

class GetAllCoursesUseCase (
    private val repository: CoursesRepository
) {
    suspend fun invoke(offset:Int,pageSet:Int,dataBaseSize:Int): Result<List<CoursesDomainModel>> = runCatching {
        if(dataBaseSize==0){
            repository.getApiCourses(offset,pageSet,dataBaseSize)
        }else{
            try {
                val localResult = repository.getCoursesByDataBase(offset,pageSet)
                localResult.ifEmpty {
                    repository.getApiCourses(offset, pageSet, dataBaseSize)
                }
            }catch (e: Exception){
                repository.getApiCourses(offset,pageSet,dataBaseSize)
            }
        }
    }
}