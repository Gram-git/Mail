package com.example.mail.presentation.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mail.data.Repository
import com.example.mail.presentation.model.MailHolderUiModel
import kotlinx.coroutines.launch

class MailViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _mails: MutableLiveData<List<MailHolderUiModel>> = MutableLiveData(emptyList())
    val mails: LiveData<List<MailHolderUiModel>> = _mails
    fun onStartScreen() {
        viewModelScope.launch {
            val newMails = repository.getMails()
            _mails.value = newMails
        }
    }
    fun onBookmarkClick(mailId: Long,isBookmarked: Boolean) {
        viewModelScope.launch {
            repository.setBookmarked(mailId, isBookmarked)
        }
    }
}