package com.example.mail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fragment = RecycleFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.place_holder, fragment)
            .commit()
    }
}