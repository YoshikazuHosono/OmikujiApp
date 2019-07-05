package com.example.omikujiapp

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Vibrator
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fortune.*
import kotlinx.android.synthetic.main.omikuji.*

class OmikujiAct : AppCompatActivity(), SensorEventListener {

    val omikujiShelf = Array<OmikujiParts>(20) {
        OmikujiParts(R.drawable.result2, R.string.content4)
    }

    private var omikujiNumber = -1

    private val omikujiBox = OmikujiBox()

    lateinit var manager: SensorManager

    lateinit var vibrator: Vibrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)

        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val value = pref.getBoolean("button", false)

        button.visibility = if (value) View.VISIBLE else View.INVISIBLE

        omikujiBox.omikujiView = imageView

        omikujiShelf[0].drawID = R.drawable.result1
        omikujiShelf[0].fortuneID = R.string.content2
        omikujiShelf[1].drawID = R.drawable.result3
        omikujiShelf[1].fortuneID = R.string.content3
        omikujiShelf[2].fortuneID = R.string.content4
    }

    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        val sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            if (omikujiNumber < 0 && omikujiBox.finish) {
                val pref = PreferenceManager.getDefaultSharedPreferences(this)
                if (pref.getBoolean("vibration", false)) {
                    vibrator.vibrate(50L)
                }

                drowResult()
            }
//            else {
//                omikujiBox.shake()
//            }
        }
        return super.onTouchEvent(event)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val toast = Toast.makeText(this, item.title, Toast.LENGTH_LONG)
//        toast.show()

        var intent: Intent
        if (item.itemId == R.id.item1) {
            intent = Intent(this, OmikujiPreferenceActivity::class.java)
        } else {
            intent = Intent(this, AboutAct::class.java)
        }
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }

    fun onButtonClick() {
        omikujiBox.shake()
    }

    private fun drowResult() {
        omikujiNumber = omikujiBox.number
        val omikujiResult = omikujiShelf[omikujiNumber]
        setContentView(R.layout.fortune)
        imageView2.setImageResource(omikujiResult.drawID)
        textView.setText(omikujiResult.fortuneID)

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (omikujiNumber < 0 && omikujiBox.checkShake(event)) {
            omikujiBox.shake()
        }

    }

}
