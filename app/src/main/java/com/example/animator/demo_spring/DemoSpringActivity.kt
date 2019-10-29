package com.example.animator.demo_spring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_demo_spring.*

class DemoSpringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_spring)

        btnAnimate.setOnClickListener {
            animateText()
        }
    }

    private fun animateText() {
        val springForce = SpringForce()
        springForce.finalPosition = 200.0F
        springForce.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        springForce.stiffness = SpringForce.STIFFNESS_HIGH

        val animationX = SpringAnimation(tvDemo, SpringAnimation.TRANSLATION_X)
        animationX.spring = springForce

        animationX.start()
    }
}
