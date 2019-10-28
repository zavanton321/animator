package com.example.animator.spring

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_spring.*


class SpringActivity : AppCompatActivity() {

    private var diffX: Float = 0F
    private var diffY: Float = 0F

    private val springForce: SpringForce by lazy {
        SpringForce(0f).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }
    }

    private val animationX: SpringAnimation by lazy {
        SpringAnimation(tvDemo, DynamicAnimation.TRANSLATION_X)
            .setSpring(springForce)
    }

    private val animationY: SpringAnimation by lazy {
        SpringAnimation(tvDemo, DynamicAnimation.TRANSLATION_Y)
            .setSpring(springForce)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring)

        setupTouchListener()
    }

    private fun setupTouchListener() {

        tvDemo.setOnTouchListener { view, motionEvent ->

            when (motionEvent.action) {

                MotionEvent.ACTION_DOWN -> {
                    diffX = motionEvent.rawX - view.x
                    diffY = motionEvent.rawY - view.y

                    animationX.cancel()
                    animationY.cancel()
                }

                MotionEvent.ACTION_MOVE -> {
                    view.x = motionEvent.rawX - diffX
                    view.y = motionEvent.rawY - diffY
                }

                MotionEvent.ACTION_UP -> {
                    animationX.start()
                    animationY.start()
                }
            }

            true
        }
    }
}