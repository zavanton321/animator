package com.example.animator.demo_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_rotate.*

class FloatPropertyCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_float_property_compat)

        val springForce = SpringForce(1.0F)

        val animationProperty = object : FloatPropertyCompat<View>("some_name_here") {
            override fun getValue(target: View): Float {
                return target.scaleX
            }

            override fun setValue(target: View, value: Float) {
                target.scaleX = value
                target.scaleY = value
            }
        }

        val animationScale = SpringAnimation(ivCat, animationProperty)
        animationScale.spring = springForce
        animationScale.minimumVisibleChange = DynamicAnimation.MIN_VISIBLE_CHANGE_SCALE

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
                    animationScale.start()
                }
                MotionEvent.ACTION_MOVE -> {
                    animationScale.cancel()
                }
            }

            scaleGestureDetector.onTouchEvent(event)

            true
        }
    }
}
