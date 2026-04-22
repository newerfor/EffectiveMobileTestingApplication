package com.example.feature_main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesUIState
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Main(navController: NavController){
    Column(Modifier.fillMaxSize().background(Background).systemBarsPadding()) {
        Column(Modifier.weight(1f)){
            MainView()
        }
        Column {
            NavigationBar(
                navController =navController ,
            )
        }
    }

}
@Composable
fun MainView(
    coursesViewModel: CoursesViewModel = koinViewModel ()
){
    val coursesUiState by coursesViewModel.coursesUiState.collectAsState()
    LaunchedEffect(Unit) {
        coursesViewModel.getAllCourses()
    }
    Column(Modifier.fillMaxSize().padding(top = 16.dp)){
        MainScreenControlState(coursesUiState,coursesViewModel)
    }
}
