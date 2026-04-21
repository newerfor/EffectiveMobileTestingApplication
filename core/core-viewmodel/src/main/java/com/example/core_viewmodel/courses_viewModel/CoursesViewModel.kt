package com.example.core_viewmodel.courses_viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository
import com.example.core_domain.useCase.GetAllCoursesUseCase
import com.example.core_domain.useCase.GetCoursesByLikeUseCase
import com.example.core_domain.useCase.SaveCoursesUseCase
import com.example.core_viewmodel.userInfo_viewModel.UserInfoUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.onSuccess

class CoursesViewModel(
    private val getAllCoursesUseCase: GetAllCoursesUseCase,
    private val getCoursesByLikeUseCase: GetCoursesByLikeUseCase,
    private val saveCoursesUseCase: SaveCoursesUseCase
) : ViewModel() {
    private val _coursesUiState = MutableStateFlow<CoursesUIState>(CoursesUIState.Loading)
    val coursesUiState: StateFlow<CoursesUIState> = _coursesUiState.asStateFlow()
    private var offSet = 0
    private var dataBaseSize = 0
    private val pageSet = 5
    fun getAllCourses() {
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            Log.d("dgkjnbsdfgjkbdghjbd",_coursesUiState.value.toString())
            val result = getAllCoursesUseCase.invoke(offSet, pageSet, dataBaseSize)
            result.onSuccess { user ->
                offSet += pageSet
                dataBaseSize += user.size
                _coursesUiState.value = CoursesUIState.Success(user)
            }.onFailure { error ->
                if (error.toString() == "Данные пусты") {
                    _coursesUiState.value = CoursesUIState.Empty
                } else {
                    _coursesUiState.value = CoursesUIState.Error(error.toString())
                }
            }
        }
    }
    fun saveCourses(courses: CoursesDomainModel) {
        viewModelScope.launch {
            saveCoursesUseCase.invoke(courses)
        }
    }
    fun getCoursesByLike(){
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            val result = getCoursesByLikeUseCase.invoke(offSet,pageSet)
            result.onSuccess { user ->
                offSet += pageSet
                _coursesUiState.value = CoursesUIState.Success(user)
            }.onFailure { error ->
                if (error.toString() == "Данные пусты") {
                    _coursesUiState.value = CoursesUIState.Empty
                } else {
                    _coursesUiState.value = CoursesUIState.Error(error.toString())
                }
            }
        }
    }
}