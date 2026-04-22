package com.example.feature_main.SearchAndFilters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun SearchAndFiltersScreen(coursesViewModel: CoursesViewModel) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp)){
        Row(Modifier.fillMaxWidth()){
            Column(Modifier.weight(1f)){
                SearchSpace()
            }
            Spacer(Modifier.width(8.dp))
            SearchFiltersSpace()
        }
        Spacer(Modifier.height(16.dp))
        SortedSpace(coursesViewModel)
    }

}

