package com.example.omikujiapp

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
}
