package com.example.mail.presentation.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mail.MailAdapter
import com.example.mail.R
import com.example.mail.controller.MailController


class RecycleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycle, container, false)
    }

    private val controller = MailController()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataSet = controller.loadMailsList()
        val mailAdapter = MailAdapter(dataSet)

        val recyclerView: RecyclerView = view.findViewById(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = mailAdapter
    }

}