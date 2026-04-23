package com.example.feature_single_course

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.CoursesUIState
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CourseInfoMain(navController: NavController,id:Int){
    Column(Modifier.fillMaxSize().background(Background).navigationBarsPadding()) {
        Column(Modifier.weight(1f)){
            CourseInfoView(id=id)
        }
        Column {
            NavigationBar(
                navController =navController ,
            )
        }
    }

}
@Composable
fun CourseInfoView(
    coursesViewModel: CoursesViewModel = koinViewModel(),
    id:Int
){
    val coursesUiState by coursesViewModel.coursesUiState.collectAsState()
    LaunchedEffect(Unit) {
        coursesViewModel.getCourseById(id)
    }
    Column(Modifier.fillMaxSize()){
        CoursesUIState(coursesUiState, onSuccess = { courses->
            CourseInfoScreen(courses[0])
        }){
            coursesViewModel.getAllCourses()
        }
    }
}