package com.example.mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.mail.presentation.model.MailHolderUiModel

class MailAdapter(private val dataSet: List<MailHolderUiModel>) :
    RecyclerView.Adapter<MailAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val senderName: TextView
        val messageTitle: TextView
        val message: TextView
        val date: TextView
        val avatarIcon: ImageView
        val rootLayout: View = view.findViewById(R.id.main)
        val iconBookmarked: ImageView = view.findViewById(R.id.iconBookmarked)

        init {
            senderName = view.findViewById(R.id.senderName)
            messageTitle = view.findViewById(R.id.messageTitle)
            message = view.findViewById(R.id.message)
            date = view.findViewById(R.id.date)
            avatarIcon = view.findViewById(R.id.avatarIconRes)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_mail, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.senderName.text = dataSet[position].sender.name
        viewHolder.messageTitle.text = dataSet[position].messageTitle
        viewHolder.message.text = dataSet[position].message
        viewHolder.date.text = dataSet[position].date
        viewHolder.avatarIcon.setImageResource(dataSet[position].sender.fallbackAvatarRes)
        val context = viewHolder.itemView.context
        val color = if (dataSet[position].isBookmarked) {
            ContextCompat.getColor(context, R.color.holo_green_dark)
        } else {
            ContextCompat.getColor(context, R.color.black)
        }
        viewHolder.iconBookmarked.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)

        viewHolder.iconBookmarked.setOnClickListener {
            dataSet[position].isBookmarked = !dataSet[position].isBookmarked
            notifyItemChanged(position)
        }

        viewHolder.rootLayout.setOnClickListener {
            Toast.makeText(
                viewHolder.itemView.context,
                "Открытие письма: ${dataSet[position].messageTitle}",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount() = dataSet.size

}