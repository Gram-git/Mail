package com.example.mail

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.mail.data.MailsReaderDbHelper
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val db by lazy { MailsReaderDbHelper(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Top Bar: назад + "Удалить"
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar_detail)
        toolbar.setNavigationOnClickListener { parentFragmentManager.popBackStack() }
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.action_delete) {
                deleteMailAndExit()
                true
            } else false
        }

        // --- Вьюхи
        val tvSubject = view.findViewById<TextView>(R.id.tvSubject)
        val tvSender  = view.findViewById<TextView>(R.id.tvSender)
        val tvDate    = view.findViewById<TextView>(R.id.tvDate)
        val tvBody    = view.findViewById<TextView>(R.id.tvBody)
        val ivAvatar  = view.findViewById<ImageView>(R.id.ivAvatar)
        val btnStar   = view.findViewById<ImageButton>(R.id.btnStar)

        // --- Аргументы
        val args = arguments
        val mailId     = args?.getLong("MAIL_ID", -1L) ?: -1L
        val title      = args?.getString("TITLE").orEmpty()
        val senderName = args?.getString("SENDER_NAME") ?: "Без отправителя"
        val date       = args?.getString("DATE") ?: ""
        val body       = args?.getString("BODY") ?: ""
        val avatarUrl  = args?.getString("AVATAR_URL")
        var starred    = args?.getBoolean("STARRED", false) ?: false

        // --- (6) Пометить как прочитанное
        if (mailId != -1L) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                db.setRead(mailId, true)
            }
        }

        // --- Подставляем данные
        tvSubject.text = title
        tvSender.text  = senderName
        tvDate.text    = date
        tvBody.text    = body

        ivAvatar.load(avatarUrl) {
            crossfade(true)
            placeholder(R.drawable.avatar_placeholder)
            error(R.drawable.avatar_error)
            fallback(R.drawable.avatar_placeholder)
            transformations(CircleCropTransformation())
        }

        fun updateStarIcon() {
            btnStar.setImageResource(
                if (starred) R.drawable.baseline_star_24
                else R.drawable.baseline_star_border_24
            )
        }
        updateStarIcon()

        btnStar.setOnClickListener {
            starred = !starred
            updateStarIcon()
            if (mailId != -1L) {
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    db.setBookmarked(mailId, starred)
                }
            }
        }
    }

    private fun deleteMailAndExit() {
        val mailId = arguments?.getLong("MAIL_ID", -1L) ?: -1L
        if (mailId == -1L) {
            Toast.makeText(requireContext(), "Нет ID письма — удаление недоступно", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
            return
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            db.deleteById(mailId)
            withContext(Dispatchers.Main) { parentFragmentManager.popBackStack() }
        }
    }
}
