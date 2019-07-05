package com.example.omikujiapp

import android.hardware.SensorEvent
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import java.util.*

class OmikujiBox : AnimationListener {
    lateinit var omikujiView: ImageView

    var finish = false

    var beforeTime = 0L

    var beforeValue = 0F

    val number: Int
        get() {
            return Random().nextInt(3)
        }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
        omikujiView.setImageResource(R.drawable.omikuji2)
    }

    override fun onAnimationStart(p0: Animation?) {
    }

    fun shake() {
        val translate = TranslateAnimation(0f, 0f, 0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        val rotate = RotateAnimation(0f, -36f, omikujiView.width / 2f, omikujiView.width / 2f)
        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(translate)
        set.addAnimation(rotate)

        set.setAnimationListener(this)

        omikujiView.startAnimation(set)

        finish = true
    }

    fun checkShake(event: SensorEvent?): Boolean {
        val nowTime = System.currentTimeMillis()
        val diffTime = nowTime - beforeTime
        val nowValue = (event?.values?.get(0) ?: 0F) + (event?.values?.get(1) ?: 0F)

        if (1500 < diffTime) {
            val speed = Math.abs(nowValue - beforeValue) / diffTime * 10000
            beforeTime = nowTime
            beforeValue = nowValue

            if (50 < speed) {
                return true
            }
        }
        return false
    }

}
