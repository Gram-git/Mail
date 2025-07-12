package com.example.mail.presentation.model

data class MailHolderUiModel(
    val id: Long,
    val sender: SenderUiModel,
    val messageTitle: String,
    val message: String,
    var isBookmarked: Boolean,
    val date: String,
    val isRead: Boolean
)