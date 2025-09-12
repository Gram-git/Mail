package com.example.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecycleFragment : Fragment() {

    private lateinit var helper: MailsReaderDbHelper
    private lateinit var mailAdapter: MailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = MailsReaderDbHelper(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recycle, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mailAdapter = MailAdapter().apply {
            onBookmarkPersist = { mailId, isBookmarked ->
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    helper.setBookmarked(mailId, isBookmarked)
                }
            }
            onMailClick = { mail ->
                (activity as? MainActivity)?.openDetail(
                    mail.id,
                    mail.messageTitle,
                    mail.sender?.name ?: "Без отправителя",
                    mail.date,
                    mail.message,
                    mail.sender?.avatarUrl,
                    mail.isBookmarked
                )
            }
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.setHasFixedSize(true)
        recycler.adapter = mailAdapter

        // первичная загрузка
        reloadMails()
    }

    override fun onResume() {
        super.onResume()
        // обновление после возврата с деталки (прочитано/удалено/звезда)
        reloadMails()
    }

    private fun reloadMails() {
        viewLifecycleOwner.lifecycleScope.launch {
            val loaded = withContext(Dispatchers.IO) {
                helper.getMails().orEmpty()
            }
            mailAdapter.dataSet = loaded
            mailAdapter.notifyDataSetChanged()
        }
    }
}
