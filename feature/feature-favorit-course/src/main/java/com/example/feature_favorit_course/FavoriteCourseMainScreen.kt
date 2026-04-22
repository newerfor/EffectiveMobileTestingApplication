package com.example.feature_favorit_course

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun FavoriteCourseMainScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel
) {
    Text("Избранное")
    FavoriteCourseScreen(courses,coursesViewModel)
}