package com.example.core_data.remote.remoteRepository

import android.util.Log
import com.example.core_data.constant.ApiConstant.SECOND_BASE_URL
import com.example.core_data.remote.api.ApiService
import com.example.core_data.remote.model.CoursesModel

class RemoteRepositoryImpl(
    private val apiService: ApiService,
    private val secondApiService: ApiService
) : RemoteDataSource {

    override suspend fun getCoursesRemote(): CoursesModel {
        return try {
            // Пытаемся получить через основной API
            apiService.getCourses()
        } catch (e: Exception) {
            // Если ошибка — пробуем через второй
            try {
                secondApiService.getCoursesSecondApi()
            } catch (e2: Exception) {
                Log.d("Pagination", "GG Отвал обоих ${e.message}, ${e2.message}")
                throw Exception("Оба API недоступны: ${e.message}, ${e2.message}")
            }
        }
    }
}