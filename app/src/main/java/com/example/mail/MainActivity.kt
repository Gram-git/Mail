package com.example.mail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mail.presentation.main_screen.RecycleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = RecycleFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.place_holder, fragment)
            .commit()
    }

    //  ado
    fun openDetail(
        mailId: Long,
        title: String,
        senderName: String,
        date: String,
        body: String,
        avatarUrl: String?,
        starred: Boolean
    ) {
        val fragment = DetailFragment()

        val bundle = Bundle().apply {
            putLong("MAIL_ID", mailId)
            putString("TITLE", title)
            putString("SENDER_NAME", senderName)
            putString("DATE", date)
            putString("BODY", body)
            putString("AVATAR_URL", avatarUrl)
            putBoolean("STARRED", starred)
        }
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)         // опционально, но полезно
            .replace(R.id.place_holder, fragment) // <-- ЗАМЕНА
            .addToBackStack(null)
            .commit()

    }

}