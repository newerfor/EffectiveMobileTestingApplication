package com.example.feature_single_course

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.CourseInfoChipText
import com.example.core_ui.ui.CoursesCard.GlassChip
import com.example.core_ui.ui.dateHelperIntToString
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import com.example.core_ui.R
import com.example.core_ui.theme.Background
import com.example.core_ui.theme.TextPrimary

@Composable
fun CourseInfoImageSpace(rate: String, startDate: String) {
    val hazeState = rememberHazeState()

    Box(
        Modifier.fillMaxWidth().height(250.dp)
    ){
        Image(
            painter = painterResource(com.example.feature_single_course.R.drawable.courses_image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState),
            contentScale = ContentScale.Crop,
        )
        Row(
            Modifier
                .fillMaxWidth()
                .systemBarsPadding().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(44.dp).clip(RoundedCornerShape(28.dp)).background(TextPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(com.example.feature_single_course.R.drawable.arrow_go_back),
                    contentDescription = null,
                    tint = Background,
                    modifier = Modifier
                        .offset(y = 1.dp)
                )
            }

            Box(
                Modifier.size(44.dp).clip(RoundedCornerShape(28.dp)).background(TextPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(com.example.feature_single_course.R.drawable.book_mark_courses_info),
                    contentDescription = null,
                    tint = Background,
                    modifier = Modifier
                        .offset(y = 1.dp)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            GlassChip(hazeState) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = BrandGreen,
                    modifier = Modifier.size(12.dp)
                )
                CourseInfoChipText(text = rate)
            }
            Spacer(Modifier.width(4.dp))
            GlassChip(hazeState) {
                CourseInfoChipText(text = dateHelperIntToString(startDate))
            }
        }
    }
}