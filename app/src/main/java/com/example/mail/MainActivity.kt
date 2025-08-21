package com.example.mail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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

    fun openDetail(title: String) {
        val fragment = DetailFragment()

        val bundle = Bundle()
        bundle.putString("TITLE", title)

        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .add(R.id.place_holder, fragment)
            .addToBackStack(null)
            .commit()
    }
}