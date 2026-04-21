package com.example.feature_main

import androidx.compose.runtime.Composable
import com.example.core_domain.model.CoursesDomainModel

@Composable
fun MainScreen(courses: List<CoursesDomainModel>) {
    SearchAndFiltersScreen()
    CoursesScreen(courses)
}