package com.example.mail.presentation.model

import androidx.annotation.DrawableRes
import com.example.mail.R

data class SenderUiModel(
    val id: Long,
    val name: String,
    val avatarUrl: String?,
    @DrawableRes
    val fallbackAvatarRes: Int = R.drawable.outline_android_24,
)