package com.mail.api.model

data class MailDto(
    val id: Long,
    val sender: UserDto,
    val messageTitle: String,
    val message: String,
    val isBookmarked: Boolean,
    val dateTimeMillis: Long,
    val isRead: Boolean
)