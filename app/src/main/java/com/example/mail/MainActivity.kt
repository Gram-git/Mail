package com.example.mail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mail.controller.MailController

class MainActivity : AppCompatActivity() {

    private val controller = MailController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val dataSet = controller.loadMailsList()
        val mailAdapter = MailAdapter(dataSet)

        val recyclerView: RecyclerView = findViewById(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mailAdapter
    }
}