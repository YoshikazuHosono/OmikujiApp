package com.example.omikujiapp

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about.*

class AboutAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        try {
            val info = packageManager.getPackageInfo(packageName, 0)
            textView2.text = "Version ${info.versionName}"
            } catch (e: PackageManager.NameNotFoundException) {
            // do error processing...
        }

    }
}