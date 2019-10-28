package com.example.animator.custom_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_custom_spring.*

class CustomSpringActivity : AppCompatActivity() {

    private var diffX: Float = 0F
    private var diffY: Float = 0F

    private lateinit var force: SpringForce
    private lateinit var animationX: SpringAnimation
    private lateinit var animationY: SpringAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_spring)

        force = SpringForce(0F)
        force.stiffness = SpringForce.STIFFNESS_MEDIUM
        force.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY

        animationX = SpringAnimation(tvDemo, SpringAnimation.TRANSLATION_X)
        animationX.spring = force

        animationY = SpringAnimation(tvDemo, SpringAnimation.TRANSLATION_Y)
        animationY.spring = force

        tvDemo.setOnTouchListener(object : View.OnTouchListener {

            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {

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
                return true
            }
        })
    }
}
