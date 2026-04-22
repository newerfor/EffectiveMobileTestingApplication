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
    private var coursesInfo = mutableListOf<CoursesDomainModel>()
    private var isSorted = false
    private var dataBaseSize = 0
    private val pageSet = 2
    fun getAllCourses() {
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            val result = getAllCoursesUseCase.invoke(offSet, pageSet, dataBaseSize)
            result.onSuccess { courses ->
                coursesInfo.addAll(courses)
                offSet += pageSet
                dataBaseSize += courses.size
                _coursesUiState.value = CoursesUIState.Success(courses)
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
    fun sortingList(){
        _coursesUiState.value = CoursesUIState.Loading
        isSorted = true
        _coursesUiState.value = CoursesUIState.Success(sortingHelper(coursesInfo))
    }
    fun getNextPage() {
        viewModelScope.launch {
            Log.d("ViewModel", "=== getNextPage ===")
            Log.d("ViewModel", "До вызова: coursesInfo.size=${coursesInfo.size}, offSet=$offSet")

            val result = getAllCoursesUseCase.invoke(offSet, pageSet, dataBaseSize)
            result.onSuccess { courses ->
                Log.d("ViewModel", "GetNextPage: получено ${courses.size} курсов")
                courses.forEach { course ->
                    Log.d("ViewModel", "  Новый курс: id=${course.id}, title=${course.title}")
                }

                coursesInfo.addAll(courses)
                offSet += pageSet
                dataBaseSize += courses.size

                val sortedList = sortingHelper(coursesInfo)
                Log.d("ViewModel", "Перед обновлением _coursesUiState: sortedList.size=${sortedList.size}")

                _coursesUiState.value = CoursesUIState.Success(sortedList)

                Log.d("ViewModel", "✅ _coursesUiState обновлён! Новое значение содержит ${(_coursesUiState.value as CoursesUIState.Success).courses.size} курсов")
            }.onFailure { error ->
                Log.e("ViewModel", "Ошибка: ${error.message}")
            }
        }
    }

    fun sortingHelper(courses: List<CoursesDomainModel>): List<CoursesDomainModel> {
        Log.d("ViewModel", "sortingHelper: isSorted=$isSorted, входной список size=${courses.size}")
        val result = if (isSorted) {
            courses.sortedByDescending { it.publishDate }
        } else {
            courses
        }
        Log.d("ViewModel", "sortingHelper: выходной список size=${result.size}")
        return result
    }
}