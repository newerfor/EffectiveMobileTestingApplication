package com.example.core_ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.R
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.theme.TextSecondary

@Composable
fun LoadRound(){
    Column(
        Modifier.Companion.fillMaxSize(),
        Arrangement.Center,
        Alignment.Companion.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.Companion.size(50.dp),
            color = TextPrimary
        )
    }
}
@Composable
fun EmptyMessage(
    title: String = "Список пуст",
    description: String = "Здесь пока ничего нет",
    buttonText: String = "Обновить",
    onButtonClick: () -> Unit = {},
    showButton: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundAvatar),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        // Заголовок
        ActionLinkText(
            text = title,
            textColor = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Описание
        CourseDescriptionText(
            text = description,
            textColor = TextSecondary
        )

        if (showButton) {
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BrandGreen
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                ButtonLabelText(text = buttonText)
            }
        }
    }
}
@Composable
fun ErrorMessage(
    onRetryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp))
                .background(BackgroundAvatar)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionLinkText(
                text = "Произошла непредвиденная ошибка",
                textColor = TextPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(Modifier.padding(5.dp)){
                Button(
                    onClick = onRetryClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BrandGreen
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    ButtonLabelText(text = "Повторить", fontSize = 12)
                }
            }
        }
    }
}