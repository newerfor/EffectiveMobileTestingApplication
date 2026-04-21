package com.example.feature_main

import androidx.compose.runtime.Composable
import com.example.core_viewmodel.courses_viewModel.CoursesUIState

@Composable
fun MainScreenControlState(coursesUiState: CoursesUIState) {
    when(coursesUiState){
        is CoursesUIState.Empty->{

        }
        is CoursesUIState.Error->{

        }
        is CoursesUIState.Success->{
            MainScreen(coursesUiState.courses)
        }
        is CoursesUIState.Loading->{

        }
    }
}