package com.example.mail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mail.controller.MailController

class MailAdapter(private val dataset:) : RecyclerView.Adapter<MailAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val senderName: TextView
        val messageTitle: TextView
        val message: TextView
        val date: TextView
        val avatarIcon: ImageView
        val iconBookmarked: ImageView

        init {
            senderName = view.findViewById(R.id.senderName)
            messageTitle = view.findViewById(R.id.messageTitle)
            message = view.findViewById(R.id.message)
            date = view.findViewById(R.id.date)
            avatarIcon = view.findViewById(R.id.avatarIconRes)
            iconBookmarked = view.findViewById(R.id.iconBookmarked)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

}