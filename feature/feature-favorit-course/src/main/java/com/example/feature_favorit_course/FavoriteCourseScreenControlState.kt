package com.example.feature_favorit_course

import androidx.compose.runtime.Composable
import com.example.core_viewmodel.courses_viewModel.CoursesUIState
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun FavoriteCourseScreenControlState(coursesUiState: CoursesUIState, coursesViewModel: CoursesViewModel) {
    when(coursesUiState){
        is CoursesUIState.Empty->{

        }
        is CoursesUIState.Error->{

        }
        is CoursesUIState.Success->{
            FavoriteCourseMainScreen(coursesUiState.courses, coursesViewModel)
        }
        is CoursesUIState.Loading->{

        }
    }
}