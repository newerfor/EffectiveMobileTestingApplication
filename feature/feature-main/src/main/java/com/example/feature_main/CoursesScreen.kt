package com.example.feature_main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesCard
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CoursesScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel
) {
    // Добавь этот лог
    LaunchedEffect(courses) {
        Log.d("UIKA", "=== CoursesScreen получил обновление ===")
        Log.d("UIKA", "courses.size = ${courses.size}")
        courses.forEachIndexed { index, course ->
            Log.d("UIKA", "  courses[$index] = id=${course.id}, title=${course.title}")
        }
    }

    val listState = rememberLazyListState()

    LaunchedEffect(listState, courses.size) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collectLatest { lastVisibleIndex ->
                if (lastVisibleIndex != null && courses.isNotEmpty()) {
                    val isAtEnd = lastVisibleIndex >= courses.size - 1
                    Log.d("UIKA", "lastVisibleIndex=$lastVisibleIndex, total=${courses.size}, isAtEnd=$isAtEnd")
                    if (isAtEnd) {
                        Log.d("UIKA", "🏁 Достигнут конец списка, загружаем следующую страницу")
                        coursesViewModel.getNextPage()
                    }
                }
            }
    }

    LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
        items(courses) { course ->
            Log.d("UIKA", "Отрисовывается курс: id=${course.id}, title=${course.title}")
            CoursesCard(course, imageIndex = course.id % 3, coursesViewModel = coursesViewModel)
            Spacer(Modifier.height(16.dp))
        }
    }
}