package com.example.feature_main.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesView
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.constant.MainViewConstant.SPACER_FILTER_TO_COURSES_CARD
import com.example.feature_main.ui.SearchAndFilters.SearchAndFiltersScreen

@Composable
fun MainScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
    onLoading: MutableState<Boolean>,
    onEmpty: MutableState<Boolean>,
    listState: ScrollState
) {
    SearchAndFiltersScreen(coursesViewModel)
    Spacer(Modifier.height(SPACER_FILTER_TO_COURSES_CARD))
    CoursesView(courses,coursesViewModel,listState,onLoading,onEmpty){
        coursesViewModel.getNextPage()
    }
}