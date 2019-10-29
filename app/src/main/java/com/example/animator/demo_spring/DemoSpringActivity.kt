package com.example.animator.demo_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_demo_spring.*

class DemoSpringActivity : AppCompatActivity() {

    private var diffX: Float = 0.0F
    private var diffY: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_spring)

        val force = SpringForce().apply {
            finalPosition = 0.0F
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            stiffness = SpringForce.STIFFNESS_HIGH
        }

        val animationX = createSpringAnimation(tvDemo, force, SpringAnimation.TRANSLATION_X)

        val animationY = createSpringAnimation(tvDemo, force, SpringAnimation.TRANSLATION_Y)

        tvDemo.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> onDown(motionEvent, view, animationX, animationY)
                MotionEvent.ACTION_MOVE -> onMove(view, motionEvent)
                MotionEvent.ACTION_UP -> onUp(animationX, animationY)
            }
            true
        }
    }

    private fun createSpringAnimation(
        view: View,
        force: SpringForce,
        property: DynamicAnimation.ViewProperty
    ): SpringAnimation =
        SpringAnimation(view, property)
            .apply {
                spring = force
            }

    private fun onDown(
        motionEvent: MotionEvent,
        view: View,
        animationX: SpringAnimation,
        animationY: SpringAnimation
    ) {
        diffX = motionEvent.rawX - view.x
        diffY = motionEvent.rawY - view.y

        animationX.cancel()
        animationY.cancel()
    }

    private fun onMove(view: View, motionEvent: MotionEvent) {
        view.animate()
            .x(motionEvent.rawX - diffX)
            .y(motionEvent.rawY - diffY)
            .setDuration(0)
            .start()
    }

    private fun onUp(
        animationX: SpringAnimation,
        animationY: SpringAnimation
    ) {
        animationX.start()
        animationY.start()
    }
}
