package com.example.feature_main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesCard

@Composable
fun CoursesScreen(courses: List<CoursesDomainModel>) {
    var imageIndex by remember { mutableStateOf(0) }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())){
        for (course in courses) {
            CoursesCard(course, imageIndex)
            if (imageIndex == 2) {
                imageIndex = 0
            }
            imageIndex++
        }
    }
}