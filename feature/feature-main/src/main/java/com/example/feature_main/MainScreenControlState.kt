package com.example.feature_main

import androidx.compose.runtime.Composable
import com.example.core_viewmodel.courses_viewModel.CoursesUIState
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun MainScreenControlState(coursesUiState: CoursesUIState, coursesViewModel: CoursesViewModel) {
    when(coursesUiState){
        is CoursesUIState.Empty->{

        }
        is CoursesUIState.Error->{

        }
        is CoursesUIState.Success->{
            MainScreen(coursesUiState.courses, coursesViewModel)
        }
        is CoursesUIState.Loading->{

        }
    }
}