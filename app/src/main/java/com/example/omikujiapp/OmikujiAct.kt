package com.example.omikujiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.omikuji.*
import kotlinx.android.synthetic.main.omikuji_act.*
import java.util.*

class OmikujiAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)

//        val rand = Random()
//        val number = rand.nextInt(20)
//
//        val omikujiAry = Array<String>(20, { "吉" })
//        omikujiAry[0] = "大吉"
//        omikujiAry[19] = "凶"
//
//        val str = omikujiAry[number]
//        hello_view.text = str
//
//        for (omikuji in omikujiAry) {
//            println(omikuji)
//        }
    }

    fun onButtonClick(v: View) {
        val translate = TranslateAnimation(0f, 0f, 0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        val rotate = RotateAnimation(0f, -36f, imageView.width / 2f, imageView.width / 2f)
        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(translate)
        set.addAnimation(rotate)

        imageView.startAnimation(set)

//        imageView.setImageResource(R.drawable.result1)
    }

}
