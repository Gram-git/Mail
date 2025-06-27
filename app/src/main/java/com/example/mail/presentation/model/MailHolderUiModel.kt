package com.example.mail.presentation.model

data class MailHolderUiModel(
    val id: Long,
    val sender: SenderUiModel,
    val messageTitle: String,
    val message: String,
    val isBookmarked: Boolean,
    val date: String,
    val isRead: Boolean
)