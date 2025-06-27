package com.mail.api.repository

import com.mail.api.model.MailDto

interface MailRepository {

    fun loadMailsList(): List<MailDto>

}