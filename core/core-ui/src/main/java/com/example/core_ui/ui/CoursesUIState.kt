package com.example.core_ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_viewmodel.courses_viewModel.CoursesUIState

@Composable
fun CoursesUIState(
    coursesUiState: CoursesUIState,
    onLoading: MutableState<Boolean> = mutableStateOf(false),
    onEmpty: MutableState<Boolean> = mutableStateOf(false),
    onSuccess: @Composable (List<CoursesDomainModel>) -> Unit,
    onRetryClick: () -> Unit
) {
    when (coursesUiState) {
        is CoursesUIState.Empty -> {
            onEmpty.value = true
            onSuccess.invoke(coursesUiState.courses)
        }
        is CoursesUIState.Error -> {
            onEmpty.value = true
            ErrorMessage(onRetryClick)
        }
        is CoursesUIState.Success -> {
            onEmpty.value = false
            onLoading.value = false
            onSuccess.invoke(coursesUiState.courses)
        }
        is CoursesUIState.Loading -> {
            LoadRound()
        }
        is CoursesUIState.DataLoading -> {
            onLoading.value = true
            onSuccess.invoke(coursesUiState.courses)
        }
    }
}