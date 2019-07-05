package com.example.omikujiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OmikujiPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, OmikujiPreferenceFragment())
            .commit()
    }
}