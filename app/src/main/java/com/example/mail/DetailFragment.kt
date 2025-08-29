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
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailFragment : Fragment(R.layout.fragment_detail) {

    // DB helper (лениво, чтобы не создавать раньше времени)
    private val db by lazy { MailsReaderDbHelper(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Top Bar ---
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar_detail)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_delete -> {
                    deleteMailAndExit()
                    true
                }

                else -> false
            }
        }

        // --- Вьюхи контента ---
        val tvSubject = view.findViewById<TextView>(R.id.tvSubject)
        val tvSender = view.findViewById<TextView>(R.id.tvSender)
        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        val tvBody = view.findViewById<TextView>(R.id.tvBody)
        val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
        val btnStar = view.findViewById<ImageButton>(R.id.btnStar)

        // --- Аргументы (дефолты оставляем на случай, если пока передаётся только TITLE) ---
        val args = arguments
        val title = args?.getString("TITLE").orEmpty()
        val senderName = args?.getString("SENDER_NAME") ?: "Без отправителя"
        val date = args?.getString("DATE") ?: ""
        val body = args?.getString("BODY") ?: ""
        val avatarUrl = args?.getString("AVATAR_URL")
        var starred = args?.getBoolean("STARRED", false) ?: false

        val mailId = arguments?.getLong("MAIL_ID", -1L) ?: -1L
        if (mailId != -1L) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                db.setRead(mailId, true)
            }
        }

        // --- Проставляем тексты ---
        tvSubject.text = title
        tvSender.text = senderName
        tvDate.text = date
        tvBody.text = body

        // --- Аватар (Coil) ---
        ivAvatar.load(avatarUrl) {
            crossfade(true)
            placeholder(R.drawable.avatar_placeholder)
            error(R.drawable.avatar_error)
            fallback(R.drawable.avatar_placeholder) // если avatarUrl = null
            transformations(CircleCropTransformation())
        }

        // --- Звезда (локальный toggle) ---
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
            // сохранение в БД сделаем на шаге с "прочитанным/избранным"
        }
    }

    private fun deleteMailAndExit() {
        val mailId = arguments?.getLong("MAIL_ID", -1L) ?: -1L
        if (mailId == -1L) {
            Toast.makeText(
                requireContext(),
                "Нет ID письма — удаление недоступно",
                Toast.LENGTH_SHORT
            ).show()
            parentFragmentManager.popBackStack()
            return
        }

        // Удаляем в фоне, возвращаемся на главный экран на главном потоке
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                db.deleteById(mailId)
            } catch (_: Exception) { /* можно залогировать */
            }
            withContext(Dispatchers.Main) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}
