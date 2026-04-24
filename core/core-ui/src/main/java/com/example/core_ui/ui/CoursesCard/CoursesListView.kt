package com.example.core_ui.ui.CoursesCard

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.constant.CoursesCardConstant.CARD_SPACER_HEIGHT
import com.example.core_ui.ui.EmptyMessage
import com.example.core_ui.ui.LoadRound
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun CoursesView(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        for (course in courses) {
            CoursesCard(
                course = course,
                coursesViewModel = coursesViewModel
            )
            Spacer(Modifier.height(CARD_SPACER_HEIGHT))
        }
        EmptyMessage()
    }
}