package com.example.feature_single_course

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BackgroundInput
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.AboutTitleText
import com.example.core_ui.ui.AuthorLabelText
import com.example.core_ui.ui.AuthorNameText
import com.example.core_ui.ui.ButtonLabelText
import com.example.core_ui.ui.CourseDescriptionText
import com.example.core_ui.ui.CourseTitleLargeText

@Composable
fun CourseInfoScreen(courses: CoursesDomainModel) {
    CourseInfoImageSpace(courses.rate,courses.startDate)
    Column(Modifier.padding(horizontal = 16.dp).verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        CourseTitleLargeText(courses.title)
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Box(Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)), contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(R.drawable.avtor_logo),
                    contentDescription=null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,

                )
            }
            Spacer(Modifier.width(12.dp))
            Column {
                AuthorLabelText("Автор")
                AuthorNameText("Merion Academy")
            }
        }
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BrandGreen
            ),
        ) {
            ButtonLabelText("Начать курс", fontSize = 14)
        }
        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BackgroundAvatar
            ),
        ) {
            ButtonLabelText("Перейти на платформу", fontSize = 14)
        }
        Spacer(Modifier.height(28.dp))
        AboutTitleText("О курсе")
        Spacer(Modifier.height(12.dp))
        CourseDescriptionText(
            text = courses.text,
            maxLine = Int.MAX_VALUE,
            fontSize = 14,
            lineHeight = 20,
            letterSpacing =0.25
        )
    }
}