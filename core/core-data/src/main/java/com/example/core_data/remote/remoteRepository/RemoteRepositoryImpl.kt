package com.example.core_data.remote.remoteRepository

import com.example.core_data.remote.api.ApiService
import com.example.core_data.remote.model.CoursesModel

class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getCoursesRemote(): CoursesModel {
        return apiService.getCourses()
    }
}