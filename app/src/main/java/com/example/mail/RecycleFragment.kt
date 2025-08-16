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

        val mailAdapter = MailAdapter() //create

        mailAdapter.onBookmarkPersist = { mailId, isBookmarked ->
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                helper?.setBookmarked(mailId, isBookmarked)
            }
        }

        lifecycleScope.launch {
            val loadedMails = helper?.getMails() //load data

            mailAdapter.dataSet = loadedMails.orEmpty() //set items

            mailAdapter.notifyDataSetChanged() //notify
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = mailAdapter
    }

}
