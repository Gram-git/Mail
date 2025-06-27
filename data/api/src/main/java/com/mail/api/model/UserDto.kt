package com.mail.api.model

data class UserDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String? = null,
)