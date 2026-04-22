package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.R
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.CourseInfoChipText
import com.example.core_ui.ui.dateHelperIntToString
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState

@Composable
fun CardImageSpace(imageIndex: Int, course: CoursesDomainModel, coursesViewModel: CoursesViewModel){
    var isLiked = remember { mutableStateOf(course.hasLike) }
    val hazeState = rememberHazeState()
    val imageList= listOf(
        painterResource(R.drawable.first_course),
        painterResource(R.drawable.second_course),
        painterResource(R.drawable.three_course),
    )
    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = imageList[imageIndex],
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState),
            contentScale = ContentScale.Crop,
            alignment = BiasAlignment(
                horizontalBias = 0f,
                verticalBias = -0.4f
            )
        )
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            GlassCircleButton(hazeState,{
                if(isLiked.value){
                    isLiked.value=false
                }else{
                    isLiked.value = true
                }
                coursesViewModel.saveCourses(CoursesDomainModel(
                    id = course.id,
                    title = course.title,
                    text = course.text,
                    price = course.price,
                    rate = course.rate,
                    startDate = course.startDate,
                    hasLike = isLiked.value,
                    publishDate = course.publishDate
                ))
            }){
                Icon(
                    painter = if(isLiked.value){painterResource(R.drawable.bookmark_filled)}else{painterResource(R.drawable.bookmark)},
                    contentDescription = null,
                    tint =  if(isLiked.value){BrandGreen}else{TextPrimary},
                    modifier = Modifier.size(16.dp)
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
                CourseInfoChipText(text = course.rate)
            }
            Spacer(Modifier.width(4.dp))
            GlassChip(hazeState) {
                CourseInfoChipText(text = dateHelperIntToString(course.startDate))
            }
        }
    }
}