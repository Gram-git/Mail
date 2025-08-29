package com.example.mail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecycleFragment : Fragment() {
    private var helper: MailsReaderDbHelper? = null
    private lateinit var mailAdapter: MailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let { ctx ->
            helper = MailsReaderDbHelper(ctx)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mailAdapter = MailAdapter()

        mailAdapter.onBookmarkPersist = { mailId, isBookmarked ->
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                helper?.setBookmarked(mailId, isBookmarked)
            }
        }

        mailAdapter.onMailClick = { mail ->
            (activity as? MainActivity)?.openDetail(
                mail.id,
                mail.messageTitle,
                mail.sender?.name ?: "Без отправителя",
                mail.date,           // у тебя уже строка (DateUtil.formatPrettyDate)
                mail.message,
                mail.sender?.avatarUrl,
                mail.isBookmarked
            )
        }


        lifecycleScope.launch {
            val loadedMails = helper?.getMails() //load data

            mailAdapter.dataSet = loadedMails.orEmpty() //set items

            mailAdapter.notifyDataSetChanged() //notify
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = mailAdapter
    }

    override fun onResume() {
        super.onResume()
        viewLifecycleOwner.lifecycleScope.launch {
            val loaded = helper?.getMails().orEmpty()
            mailAdapter.dataSet = loaded
            mailAdapter.notifyDataSetChanged()
        }
    }

}
