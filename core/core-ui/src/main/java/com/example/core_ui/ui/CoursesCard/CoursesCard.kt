package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun CoursesCard(
    course: CoursesDomainModel,
    imageIndex: Int,
    coursesViewModel: CoursesViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(BackgroundAvatar)
    ) {
        CardImageSpace(
            imageIndex = imageIndex,
            course,
            coursesViewModel
        )
        CardTextSpace(
            title = course.title,
            text = course.text,
            price = course.price
        )
    }
}