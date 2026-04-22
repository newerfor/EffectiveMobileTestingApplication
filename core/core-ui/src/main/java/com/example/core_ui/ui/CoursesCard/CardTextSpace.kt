package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.R
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.CourseDescriptionText
import com.example.core_ui.ui.CourseMoreButtonText
import com.example.core_ui.ui.CoursePriceText
import com.example.core_ui.ui.CourseTitleText

@Composable
fun CardTextSpace(title:String,text:String,price: String){
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp)){
        Spacer(Modifier.height(16.dp))
        CourseTitleText(
            text = title,
        )
        Spacer(Modifier.height(12.dp))
        CourseDescriptionText(
            text = text,
        )
        Spacer(Modifier.height(11.dp))
        Row {
            CoursePriceText(
                text = "$price ₽",
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CourseMoreButtonText(text = "Подробнее")
                Spacer(Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = null,
                    tint = BrandGreen,
                    modifier = Modifier
                        .offset(y = 1.dp)
                )
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}