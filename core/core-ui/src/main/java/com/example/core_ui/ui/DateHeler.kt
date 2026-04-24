package com.example.core_ui.ui

import com.example.core_ui.constant.UiLogicConstant.MOUNTH_MAP

fun dateHelperIntToString(date: String): String {

    val parts = date.split("-")
    if (parts.size != 3) return date

    val year = parts[0]
    val month = MOUNTH_MAP[parts[1]] ?: return date
    val day = parts[2]

    return "$day $month $year"
}