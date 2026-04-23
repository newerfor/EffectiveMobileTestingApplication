package com.example.core_ui.ui.CoursesCard

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.EmptyMessage
import com.example.core_ui.ui.LoadRound
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun CoursesView(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
    listState: ScrollState,
    onLoading: MutableState<Boolean>,
    onEmpty: MutableState<Boolean>,
    onNext: () -> Unit,
) {
    // Проверяем, достигнут ли конец
    LaunchedEffect(listState.value, courses.size) {
        val isAtEnd = listState.value >= listState.maxValue-700
        if (isAtEnd && courses.isNotEmpty()) {
            Log.d("SCROLL_END", "Конец списка достигнут, позиция: ${listState.value}, макс: ${listState.maxValue}")
            onNext()
        }
    }

    Column(Modifier.fillMaxSize().verticalScroll(listState)) {
        for (course in courses) {
            CoursesCard(
                course = course,
                imageIndex = course.id % 3,
                coursesViewModel = coursesViewModel
            )
            Spacer(Modifier.height(16.dp))
        }
        if(onLoading.value){
            LoadRound()
            Spacer(Modifier.height(16.dp))
        }
        if(onEmpty.value){
            EmptyMessage()
        }
    }
}