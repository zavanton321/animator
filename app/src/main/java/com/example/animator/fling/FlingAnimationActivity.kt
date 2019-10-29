package com.example.animator.fling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.dynamicanimation.animation.FlingAnimation
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_fling_animation.*

class FlingAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_animation)

        btnAnimate.setOnClickListener {
            animateWithFlingAnimation()
        }

    }

    private fun animateWithFlingAnimation() {
        val fling = FlingAnimation(tvDemo, FlingAnimation.X)
        fling.setStartVelocity(1000F)
        fling.setFriction(1F)
        fling.start()
    }
}
