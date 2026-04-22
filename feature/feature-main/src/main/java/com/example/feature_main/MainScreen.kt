package com.example.feature_main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.SearchAndFilters.SearchAndFiltersScreen

@Composable
fun MainScreen(courses: List<CoursesDomainModel>, coursesViewModel: CoursesViewModel) {
    SearchAndFiltersScreen(coursesViewModel)
    Spacer(Modifier.height(16.dp))
    CoursesScreen(courses,coursesViewModel)
}