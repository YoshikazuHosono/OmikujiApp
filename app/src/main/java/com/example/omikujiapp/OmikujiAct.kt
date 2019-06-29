package com.example.omikujiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.omikuji_act.*

class OmikujiAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji_act)

        hello_view.text = "τの会のホソノ@おみくじアプリ"
    }
}
