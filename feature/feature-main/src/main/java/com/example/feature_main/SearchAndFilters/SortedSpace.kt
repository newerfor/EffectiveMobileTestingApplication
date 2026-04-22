package com.example.feature_main.SearchAndFilters

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.SortText
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.R
@Composable
fun SortedSpace(coursesViewModel: CoursesViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.clickable {
                coursesViewModel.sortingList()
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            SortText(text = "По дате добавления")
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(R.drawable.sorted_top_down_arrow),
                contentDescription = null,
                tint = BrandGreen,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}