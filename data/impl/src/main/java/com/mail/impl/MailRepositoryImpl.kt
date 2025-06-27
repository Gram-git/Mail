package com.mail.impl

import com.mail.api.model.MailDto
import com.mail.api.repository.MailRepository

class MailRepositoryImpl : MailRepository {

    override fun loadMailsList(): List<MailDto> {
        return mockMails
    }
}