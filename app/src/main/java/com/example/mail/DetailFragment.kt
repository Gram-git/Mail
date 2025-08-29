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

        // ----- данные из аргументов (есть только TITLE — остальное с дефолтами)
        val args = arguments
        tvSubject.text = args?.getString("TITLE").orEmpty()
        tvSender.text  = args?.getString("SENDER_NAME") ?: "Максим Косенко"
        tvDate.text    = args?.getString("DATE") ?: "02.12.2024"
        tvBody.text    = args?.getString("BODY") ?: "Текст письма…"

        // Аватар (Coil)
        val avatarUrl = args?.getString("AVATAR_URL")
        ivAvatar.load(avatarUrl) {
            crossfade(true)
            placeholder(R.drawable.avatar_placeholder)
            error(R.drawable.avatar_error)
            fallback(R.drawable.avatar_placeholder)
            transformations(CircleCropTransformation())
        }

        // Звезда (локальный toggle)
        var starred = args?.getBoolean("STARRED", false) ?: false
        btnStar.setImageResource(
            if (starred) R.drawable.baseline_star_24
            else R.drawable.baseline_star_border_24
        )
        btnStar.setOnClickListener {
            starred = !starred
            btnStar.setImageResource(
                if (starred) R.drawable.baseline_star_24
                else R.drawable.baseline_star_border_24
            )
        }
    }
}
