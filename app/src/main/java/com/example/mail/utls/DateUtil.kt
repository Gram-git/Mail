package com.example.mail.utls

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

object DateUtil {
    fun formatPrettyDate(timestampMillis: Long): String {
        val inputDate = Calendar.getInstance().apply { timeInMillis = timestampMillis }
        val now = Calendar.getInstance()

        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val dayOfWeekFormat = SimpleDateFormat("E", Locale("ru"))
        val shortMonthFormat = SimpleDateFormat("MMM", Locale("ru"))
        val dayMonthFormat = SimpleDateFormat("dd.MM", Locale.getDefault())
        val fullDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        fun isSameDay(cal1: Calendar, cal2: Calendar): Boolean {
            return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
        }

        fun daysBetween(from: Calendar, to: Calendar): Int {
            val diff = to.timeInMillis - from.timeInMillis
            return TimeUnit.MILLISECONDS.toDays(diff).toInt()
        }

        return when {
            inputDate.get(Calendar.YEAR) != now.get(Calendar.YEAR) ->
                fullDateFormat.format(inputDate.time)

            inputDate.get(Calendar.MONTH) != now.get(Calendar.MONTH) ->
                "${inputDate.get(Calendar.DAY_OF_MONTH)} ${shortMonthFormat.format(inputDate.time)} в ${timeFormat.format(inputDate.time)}"

            else -> {
                val daysDiff = daysBetween(inputDate, now)

                when {
                    isSameDay(inputDate, now) ->
                        timeFormat.format(inputDate.time)

                    daysDiff == 1 ->
                        "Вчера в ${timeFormat.format(inputDate.time)}"

                    daysDiff == 2 ->
                        "Позавчера в ${timeFormat.format(inputDate.time)}"

                    else ->
                        "${dayOfWeekFormat.format(inputDate.time)} в ${timeFormat.format(inputDate.time)}"
                }
            }
        }
    }
}