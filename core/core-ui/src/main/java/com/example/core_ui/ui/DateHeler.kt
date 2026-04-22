package com.example.core_ui.ui

fun dateHelperIntToString(date: String): String {
    val months = mapOf(
        "01" to "Января",
        "02" to "Февраля",
        "03" to "Марта",
        "04" to "Апреля",
        "05" to "Мая",
        "06" to "Июня",
        "07" to "Июля",
        "08" to "Августа",
        "09" to "Сентября",
        "10" to "Октября",
        "11" to "Ноября",
        "12" to "Декабря"
    )

    val parts = date.split("-")
    if (parts.size != 3) return date

    val year = parts[0]
    val month = months[parts[1]] ?: return date
    val day = parts[2]

    return "$day $month $year"
}