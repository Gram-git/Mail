package com.example.mail.data

import com.example.mail.presentation.model.SenderUiModel

data class MailEntity(
    val id: Long,
    val sender: Long,
    val messageTitle: String,
    val message: String,
    val isBookmarked: Boolean,
    val dataInMillis: Long,
    val isRead: Boolean
)