package com.example.core_ui.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.core_ui.constant.TextConstant.ACTION_LINK_FONT_SIZE
import com.example.core_ui.constant.TextConstant.ACTION_LINK_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.ACTION_LINK_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.ACTION_MENU_FONT_SIZE
import com.example.core_ui.constant.TextConstant.ACTION_MENU_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.ACTION_MENU_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.AUTHOR_LABEL_ALPHA
import com.example.core_ui.constant.TextConstant.BUTTON_LABEL_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.BUTTON_LABEL_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.CHIP_FONT_SIZE
import com.example.core_ui.constant.TextConstant.CHIP_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.CHIP_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.COURSE_DESCRIPTION_ALPHA
import com.example.core_ui.constant.TextConstant.COURSE_DESCRIPTION_FONT_SIZE
import com.example.core_ui.constant.TextConstant.COURSE_DESCRIPTION_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.COURSE_DESCRIPTION_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.COURSE_DESCRIPTION_MAX_LINES
import com.example.core_ui.constant.TextConstant.COURSE_MORE_BUTTON_FONT_SIZE
import com.example.core_ui.constant.TextConstant.COURSE_MORE_BUTTON_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.COURSE_MORE_BUTTON_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.COURSE_TITLE_FONT_SIZE
import com.example.core_ui.constant.TextConstant.COURSE_TITLE_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.COURSE_TITLE_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.ERROR_INPUT_PADDING_START
import com.example.core_ui.constant.TextConstant.INPUT_LABEL_FONT_SIZE
import com.example.core_ui.constant.TextConstant.INPUT_LABEL_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.INPUT_LABEL_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.INPUT_PLACEHOLDER_FONT_SIZE
import com.example.core_ui.constant.TextConstant.INPUT_PLACEHOLDER_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.LOGIN_TITLE_FONT_SIZE
import com.example.core_ui.constant.TextConstant.LOGIN_TITLE_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.LOGIN_TITLE_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.SORT_FONT_SIZE
import com.example.core_ui.constant.TextConstant.SORT_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.SORT_LINE_HEIGHT
import com.example.core_ui.constant.TextConstant.TITLE_FONT_SIZE
import com.example.core_ui.constant.TextConstant.TITLE_LETTER_SPACING
import com.example.core_ui.constant.TextConstant.TITLE_LINE_HEIGHT
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
        fontSize = LOGIN_TITLE_FONT_SIZE,
        lineHeight = LOGIN_TITLE_LINE_HEIGHT,
        letterSpacing = LOGIN_TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun InputLabelText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = INPUT_LABEL_FONT_SIZE,
        lineHeight = INPUT_LABEL_LINE_HEIGHT,
        letterSpacing = INPUT_LABEL_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun InputPlaceholderText(
    text: String,
    textColor: Color = TextPlaceholder
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = INPUT_PLACEHOLDER_FONT_SIZE,
        lineHeight = INPUT_PLACEHOLDER_LINE_HEIGHT,
        color = textColor,
    )
}

@Composable
fun ButtonLabelText(
    text: String,
    textColor: Color = TextPrimary,
    fontSize: Int = 16
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = fontSize.sp,
        lineHeight = BUTTON_LABEL_LINE_HEIGHT,
        letterSpacing = BUTTON_LABEL_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun ActionLinkText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = ACTION_LINK_FONT_SIZE,
        lineHeight = ACTION_LINK_LINE_HEIGHT,
        letterSpacing = ACTION_LINK_LETTER_SPACING,
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
        fontSize = ACTION_LINK_FONT_SIZE,
        lineHeight = ACTION_LINK_LINE_HEIGHT,
        letterSpacing = ACTION_LINK_LETTER_SPACING,
        color = textColor,
        modifier = Modifier.padding(start = ERROR_INPUT_PADDING_START),
    )
}

@Composable
fun CourseTitleText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = COURSE_TITLE_FONT_SIZE,
        lineHeight = COURSE_TITLE_LINE_HEIGHT,
        letterSpacing = COURSE_TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun CourseDescriptionText(
    text: String,
    textColor: Color = TextPrimary,
    maxLine: Int = COURSE_DESCRIPTION_MAX_LINES,
    fontSize: Int = COURSE_DESCRIPTION_FONT_SIZE.value.toInt(),
    lineHeight: Int = COURSE_DESCRIPTION_LINE_HEIGHT.value.toInt(),
    letterSpacing: Double = COURSE_DESCRIPTION_LETTER_SPACING.value.toDouble(),
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp,
        color = textColor.copy(alpha = COURSE_DESCRIPTION_ALPHA),
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun CoursePriceText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = COURSE_TITLE_FONT_SIZE,
        lineHeight = COURSE_TITLE_LINE_HEIGHT,
        letterSpacing = COURSE_TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun CourseMoreButtonText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = COURSE_MORE_BUTTON_FONT_SIZE,
        lineHeight = COURSE_MORE_BUTTON_LINE_HEIGHT,
        letterSpacing = COURSE_MORE_BUTTON_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun TitleText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = TITLE_FONT_SIZE,
        lineHeight = TITLE_LINE_HEIGHT,
        color = textColor,
    )
}

@Composable
fun CourseInfoChipText(
    text: String,
    textColor: Color = TextPrimary
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = CHIP_FONT_SIZE,
        lineHeight = CHIP_LINE_HEIGHT,
        letterSpacing = CHIP_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun SortText(
    text: String,
    textColor: Color = BrandGreen
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = SORT_FONT_SIZE,
        lineHeight = SORT_LINE_HEIGHT,
        letterSpacing = SORT_LETTER_SPACING,
        color = textColor,
        textAlign = TextAlign.End,
    )
}

@Composable
fun NavLabelInactiveText(
    text: String,
    textColor: Color
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = ACTION_LINK_FONT_SIZE,
        lineHeight = ACTION_LINK_LINE_HEIGHT,
        letterSpacing = ACTION_LINK_LETTER_SPACING,
        color = textColor,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun AboutTitleText(
    text: String,
    textColor: Color = TextPrimary,
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = TITLE_FONT_SIZE,
        lineHeight = TITLE_LINE_HEIGHT,
        letterSpacing = TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun CourseTitleLargeText(
    text: String,
    textColor: Color = TextPrimary,
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = TITLE_FONT_SIZE,
        lineHeight = TITLE_LINE_HEIGHT,
        letterSpacing = TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun AuthorNameText(
    text: String,
    textColor: Color = TextPrimary,
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = COURSE_TITLE_FONT_SIZE,
        lineHeight = COURSE_TITLE_LINE_HEIGHT,
        letterSpacing = COURSE_TITLE_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun AuthorLabelText(
    text: String,
    textColor: Color = TextPrimary.copy(alpha = AUTHOR_LABEL_ALPHA),
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = CHIP_FONT_SIZE,
        lineHeight = CHIP_LINE_HEIGHT,
        letterSpacing = CHIP_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun ActionMenuItemText(
    text: String,
    textColor: Color = TextPrimary,
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = ACTION_MENU_FONT_SIZE,
        lineHeight = ACTION_MENU_LINE_HEIGHT,
        letterSpacing = ACTION_MENU_LETTER_SPACING,
        color = textColor,
    )
}

@Composable
fun CourseLessonsCountText(
    text: String,
    textColor: Color = BrandGreen,
) {
    Text(
        text = text,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = CHIP_FONT_SIZE,
        lineHeight = CHIP_LINE_HEIGHT,
        letterSpacing = CHIP_LETTER_SPACING,
        textAlign = TextAlign.End,
        color = textColor,
    )
}