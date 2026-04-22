package com.example.core_ui.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.InputErrorColor
import com.example.core_ui.theme.Roboto
import com.example.core_ui.theme.TextPlaceholder
import com.example.core_ui.theme.TextPrimary

@Composable
fun LoginTitleText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        color = textColor,
    )
}

// "Email", "Пароль" — лейблы над полями
@Composable
fun InputLabelText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp,
        color = textColor,
    )
}

// "example@gmail.com", "Введите пароль" — плейсхолдеры
@Composable
fun InputPlaceholderText(
    text: String,
    textColor: Color = TextPlaceholder
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        color = textColor,
    )
}

// "Вход", "Регистрация" — текст на кнопке
@Composable
fun ButtonLabelText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
        color = textColor,
    )
}

// "Нету аккаунта? Регистрация", "Забыл пароль" — мелкие ссылки
@Composable
fun ActionLinkText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        color = textColor,
    )
}
@Composable
fun ErrorInputText(
    text: String,
    textColor: Color = InputErrorColor
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        color = textColor,
        modifier = Modifier.padding(start = 16.dp)
    )

}
// Заголовок карточки курса — "Java-разработчик с нуля"
// Android/Title medium 16/18, weight 500, letterSpacing 0.15
@Composable
fun CourseTitleText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp,
        color = textColor,
    )
}

// Описание курса — "Освойте backend-разработку..."
// Android/Body small 12/16, weight 400, letterSpacing 0.4, opacity 70%
@Composable
fun CourseDescriptionText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        color = textColor.copy(alpha = 0.7f),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

// Цена курса — "999 ₽", "12 000 ₽"
// Android/Title medium 16/18, weight 500, letterSpacing 0.15
@Composable
fun CoursePriceText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp,
        color = textColor,
    )
}

// Кнопка "Подробнее →"
// Android/Button small 12/15, weight 600, letterSpacing 0.4
@Composable
fun CourseMoreButtonText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.4.sp,
        color = textColor,
    )
}

// Рейтинг и дата на карточке — "4.9", "22 Мая 2024"
// Android/Caption 12/14, weight 400, letterSpacing 0.4
@Composable
fun CourseInfoChipText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.4.sp,
        color = textColor,
    )
}

// Сортировка — "По дате добавления"
// Android/Button 14/20, weight 500, letterSpacing 0.1
@Composable
fun SortText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        color = textColor,
        textAlign = TextAlign.End,
    )
}


// Навигация неактивная — "Избранное", "Аккаунт"
// Android/Button small 12/15, weight 600, letterSpacing 0.4
@Composable
fun NavLabelInactiveText(
    text: String,
    textColor: Color
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        color = textColor,
        textAlign = TextAlign.Center,
    )
}