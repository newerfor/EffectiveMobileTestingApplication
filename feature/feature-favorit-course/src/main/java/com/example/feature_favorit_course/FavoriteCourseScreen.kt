package com.example.feature_favorit_course

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesCard
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun FavoriteCourseScreen(courses: List<CoursesDomainModel>, coursesViewModel: CoursesViewModel) {
    for(course in courses){
        CoursesCard(course, imageIndex = course.id % 3, coursesViewModel = coursesViewModel)
        Spacer(Modifier.height(16.dp))
    }
}