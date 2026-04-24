package com.example.feature_main.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.CoursesUIState
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.constant.MainViewConstant.MAIN_TOP_PADDING
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
    coursesViewModel: CoursesViewModel = koinViewModel()
){
    val coursesUiState by coursesViewModel.coursesUiState.collectAsState()
    var onLoading = remember { mutableStateOf(false) }
    var onEmpty = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        coursesViewModel.getAllCourses()
    }
    Column(Modifier.fillMaxSize().padding(top = MAIN_TOP_PADDING)){
        CoursesUIState(coursesUiState,onLoading,onEmpty,{courses->
            MainScreen(courses, coursesViewModel)
        }){
            coursesViewModel.getAllCourses()
        }
    }
}
