//package com.example.mail
//
//import android.os.Bundle
//import android.view.View
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//
//class DetailFragment : Fragment(R.layout.fragment_detail) {
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<TextView>(R.id.tv).text = arguments?.getString("TITLE").orEmpty()
//    }
//}
package com.example.mail

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation

class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSubject = view.findViewById<TextView>(R.id.tvSubject)
        val tvSender  = view.findViewById<TextView>(R.id.tvSender)
        val tvDate    = view.findViewById<TextView>(R.id.tvDate)
        val tvBody    = view.findViewById<TextView>(R.id.tvBody)
        val ivAvatar  = view.findViewById<ImageView>(R.id.ivAvatar)
        val btnStar   = view.findViewById<ImageButton>(R.id.btnStar)

        // --- 1) Читаем аргументы (дефолты на случай, если пока передаётся только TITLE)
        val args = arguments
        val title      = args?.getString("TITLE").orEmpty()
        val senderName = args?.getString("SENDER_NAME") ?: "Без отправителя"
        val date       = args?.getString("DATE") ?: ""
        val body       = args?.getString("BODY") ?: ""
        val avatarUrl  = args?.getString("AVATAR_URL")
        var starred    = args?.getBoolean("STARRED", false) ?: false

        // --- 2) Проставляем тексты
        tvSubject.text = title
        tvSender.text  = senderName
        tvDate.text    = date
        tvBody.text    = body

        // --- 3) Грузим аватар через Coil (круглая обрезка + плейсхолдеры)
        ivAvatar.load(avatarUrl) {
            crossfade(true)
            placeholder(R.drawable.avatar_placeholder)
            error(R.drawable.avatar_error)
            fallback(R.drawable.avatar_placeholder) // если avatarUrl = null
            transformations(coil.transform.CircleCropTransformation())
        }

        // --- 4) Локальный toggle звезды
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
            // (на этом шаге только меняем иконку; запись в БД сделаем позже, в задачах 6/3)
        }
    }
}
