package com.example.core_ui.ui.CoursesCard

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.R
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.CourseDescriptionText
import com.example.core_ui.ui.CourseInfoChipText
import com.example.core_ui.ui.CourseMoreButtonText
import com.example.core_ui.ui.CoursePriceText
import com.example.core_ui.ui.CourseTitleText
import dev.chrisbanes.haze.rememberHazeState

@Composable
fun CoursesCard(course: CoursesDomainModel, imageIndex: Int) {
    val hazeState = rememberHazeState()
    val imageList= listOf(
        painterResource(R.drawable.first_course),
        painterResource(R.drawable.second_course),
        painterResource(R.drawable.three_course),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(BackgroundAvatar)
    ) {
        Box(
            modifier = Modifier
                .height(114.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = imageList[imageIndex],
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = BiasAlignment(
                    horizontalBias = 0f,
                    verticalBias = -0.4f
                )
            )
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                GlassChip(hazeState) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = BrandGreen,
                        modifier = Modifier.size(12.dp)
                    )
                    CourseInfoChipText(text = course.rate)
                }
            }
        }
        Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp)){
            Spacer(Modifier.height(16.dp))
            CourseTitleText(
                text = course.title,
            )
            Spacer(Modifier.height(12.dp))
            CourseDescriptionText(
                text = course.text,
            )
            Spacer(Modifier.height(10.dp))
            CoursePriceText(
                text = course.price,
            )
            CourseMoreButtonText(
                text = "Подробнее"
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}