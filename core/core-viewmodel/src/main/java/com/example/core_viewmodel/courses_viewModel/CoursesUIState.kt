package com.example.core_viewmodel.courses_viewModel

import com.example.core_domain.model.CoursesDomainModel


interface CoursesUIState {
    data object Loading : CoursesUIState
    data object Empty : CoursesUIState
    data class Success(val courses: List<CoursesDomainModel>) : CoursesUIState
    data class Error(val error: String) : CoursesUIState
}