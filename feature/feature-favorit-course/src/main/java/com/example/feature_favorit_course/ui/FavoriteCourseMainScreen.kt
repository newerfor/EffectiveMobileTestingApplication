package com.example.feature_favorit_course.ui

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesView
import com.example.core_ui.ui.TitleText
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_favorit_course.constant.FavoriteCourseViewConstant.LABEL_TEXT_PADDING
import com.example.feature_favorit_course.R
@Composable
fun FavoriteCourseMainScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
) {
    TitleText(stringResource(R.string.label_text))
    Spacer(Modifier.height(LABEL_TEXT_PADDING))
    CoursesView(
        courses = courses,
        coursesViewModel = coursesViewModel,
    )
}