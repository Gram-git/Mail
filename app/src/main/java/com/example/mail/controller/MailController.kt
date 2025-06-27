package com.example.mail.controller

import com.example.mail.presentation.model.MailHolderUiModel
import com.example.mail.presentation.model.SenderUiModel
import com.mail.api.model.MailDto
import com.mail.api.model.UserDto
import com.mail.api.repository.MailRepository
import com.mail.impl.MailRepositoryImpl
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

internal class MailController {
    private val repository: MailRepository = MailRepositoryImpl()

    fun loadMailsList() = repository.loadMailsList().mapToHolderUiModel()

    private fun List<MailDto>.mapToHolderUiModel() = map { dto ->
        MailHolderUiModel(
            id = dto.id,
            sender = dto.sender.mapToSenderUiModel(),
            messageTitle = dto.messageTitle,
            message = dto.message,
            isBookmarked = dto.isBookmarked,
            date = formatPrettyDate(timestampMillis = dto.dateTimeMillis),
            isRead = dto.isRead,
        )
    }

    private fun UserDto.mapToSenderUiModel() = SenderUiModel(
        id = id,
        name = "$firstName $lastName",
        avatarUrl = avatarUrl,
    )

    private fun formatPrettyDate(timestampMillis: Long): String {
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