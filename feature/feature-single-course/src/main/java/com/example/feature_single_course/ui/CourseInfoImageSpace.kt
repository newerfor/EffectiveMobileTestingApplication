package com.example.feature_single_course.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.example.core_ui.theme.Background
import com.example.core_ui.theme.TextPrimary
import com.example.feature_single_course.R
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_CLIP
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_PADDING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_ICON_STAR_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_PADDING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_SIZE

@Composable
fun CourseInfoImageSpace(rate: String, startDate: String, imageIndex: Int) {
    val hazeState = rememberHazeState()
    val imageList = listOf(
        painterResource(R.drawable.three_course_image),
        painterResource(R.drawable.courses_image),
        painterResource(R.drawable.second_course_image),
    )
    Box(
        Modifier.fillMaxWidth().height(COURSE_INFO_IMAGE_SIZE)
    ){
        Image(
            painter =imageList[imageIndex],
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState),
            contentScale = ContentScale.Crop,
        )
        Row(
            Modifier
                .fillMaxWidth()
                .systemBarsPadding().padding(COURSE_INFO_IMAGE_BUTTON_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(COURSE_INFO_IMAGE_BUTTON_ICON_SIZE).clip(RoundedCornerShape(COURSE_INFO_IMAGE_BUTTON_ICON_CLIP)).background(TextPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_go_back),
                    contentDescription = null,
                    tint = Background,
                    modifier = Modifier
                        .offset(y = COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET)
                )
            }

            Box(
                Modifier.size(COURSE_INFO_IMAGE_BUTTON_ICON_SIZE).clip(RoundedCornerShape(COURSE_INFO_IMAGE_BUTTON_ICON_CLIP)).background(TextPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.book_mark_courses_info),
                    contentDescription = null,
                    tint = Background,
                    modifier = Modifier
                        .offset(y = COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxSize().padding(COURSE_INFO_IMAGE_INFO_BOX_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            GlassChip(hazeState) {
                Icon(
                    painter = painterResource(com.example.core_ui.R.drawable.star),
                    contentDescription = null,
                    tint = BrandGreen,
                    modifier = Modifier.size(COURSE_INFO_IMAGE_INFO_BOX_ICON_STAR_SIZE)
                )
                CourseInfoChipText(text = rate)
            }
            Spacer(Modifier.width(COURSE_INFO_IMAGE_INFO_BOX_SPACER))
            GlassChip(hazeState) {
                CourseInfoChipText(text = dateHelperIntToString(startDate))
            }
        }
    }
}