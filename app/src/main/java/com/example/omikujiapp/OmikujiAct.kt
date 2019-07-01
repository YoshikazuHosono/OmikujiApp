package com.example.omikujiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.fortune.*
import kotlinx.android.synthetic.main.omikuji.*
import kotlinx.android.synthetic.main.omikuji_act.*
import java.util.*

class OmikujiAct : AppCompatActivity() {

    val omikujiShelf = Array<OmikujiParts>(20) {
        OmikujiParts(R.drawable.result2, R.string.content1)
    }

    var omikujiNumber = -1;

    val omikujiBox = OmikujiBox()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)

        omikujiBox.omikujiView = imageView

        omikujiShelf[0].drawID = R.drawable.result1
        omikujiShelf[0].fortuneID = R.string.content2
        omikujiShelf[1].drawID = R.drawable.result3
        omikujiShelf[1].fortuneID = R.string.content3
        omikujiShelf[2].fortuneID = R.string.content4

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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            if (omikujiNumber < 0 && !omikujiBox.finish) {
                drowResult()
            }
        }
        return super.onTouchEvent(event)
    }

    fun onButtonClick(v: View) {
        omikujiBox.shake()
//        imageView.setImageResource(R.drawable.result1)
    }

    fun drowResult() {
        omikujiNumber = omikujiBox.number
        val omikujiResult = omikujiShelf[omikujiNumber]
        setContentView(R.layout.fortune)
        imageView2.setImageResource(omikujiResult.drawID)
        textView.setText(omikujiResult.fortuneID)

    }
}
