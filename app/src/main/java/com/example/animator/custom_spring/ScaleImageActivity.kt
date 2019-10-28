package com.example.animator.custom_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_image.*
import kotlin.math.max
import kotlin.math.min

class ScaleImageActivity : AppCompatActivity() {

    private var scaleFactor: Float = 1F
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true
    }

    inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleFactor *= detector.scaleFactor
            scaleFactor = max(0.1F, min(scaleFactor, 10F))

            ivDemo.scaleX = scaleFactor
            ivDemo.scaleY = scaleFactor

            return true
        }
    }
}
