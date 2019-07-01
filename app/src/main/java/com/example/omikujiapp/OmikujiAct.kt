package com.example.omikujiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.omikuji_act.*
import java.util.*

class OmikujiAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji_act)

        val rand = Random()
        val number = rand.nextInt(20)

        val omikujiAry = Array<String>(20, { "吉" })
        omikujiAry[0] = "大吉"
        omikujiAry[19] = "凶"

        val str = omikujiAry[number]
        hello_view.text = str

        for (omikuji in omikujiAry) {
            println(omikuji)
        }
    }
}
