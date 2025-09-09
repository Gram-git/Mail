package com.example.mail.data

import com.example.mail.presentation.model.MailHolderUiModel

class Repository(
    private val dbHelper: MailsReaderDbHelper
) {
    suspend fun getMails(): List<MailHolderUiModel> {
        return dbHelper.getMails()
    }

    fun setBookmarked(mailId: Long, isBookmarked: Boolean) {
        return dbHelper.setBookmarked(mailId, isBookmarked)
    }
}