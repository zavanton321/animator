package com.example.animator.demo_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_rotate.*

class ScaleAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale_animation)

        val springForce = SpringForce(1.0F)

        val animationScaleX = SpringAnimation(ivCat, SpringAnimation.SCALE_X)
        animationScaleX.spring = springForce

        val animationScaleY = SpringAnimation(ivCat, SpringAnimation.SCALE_Y)
        animationScaleY.spring = springForce

        var factor = 1F
        val scaleGestureDetector = ScaleGestureDetector(this,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    factor *= detector.scaleFactor
                    ivCat.scaleX *= factor
                    ivCat.scaleY *= factor

                    return true
                }
            })

        ivCat.setOnTouchListener { _, event ->

            when (event.actionMasked) {
                MotionEvent.ACTION_UP -> {
                    animationScaleX.start()
                    animationScaleY.start()
                }
                MotionEvent.ACTION_MOVE -> {
                    animationScaleX.cancel()
                    animationScaleY.cancel()
                }
            }

            scaleGestureDetector.onTouchEvent(event)

            true
        }
    }
}
