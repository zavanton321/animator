package com.example.animator.demo_spring

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_rotate.*

class RotateActivity : AppCompatActivity() {

    private companion object Params {
        val INITIAL_ROTATION = 0f
        val STIFFNESS = SpringForce.STIFFNESS_MEDIUM
        val DAMPING_RATIO = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
    }

    lateinit var rotationAnimation: SpringAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        // create a rotation SpringAnimation
        rotationAnimation = createSpringAnimation(
            ivCat, SpringAnimation.ROTATION,
            INITIAL_ROTATION, STIFFNESS, DAMPING_RATIO
        )

        var previousRotation = 0f
        var currentRotation = 0f
        ivCat.setOnTouchListener { view, event ->
            val centerX = view.width / 2.0
            val centerY = view.height / 2.0
            val x = event.x
            val y = event.y

            // angle calculation
            fun updateCurrentRotation() {
                currentRotation = view.rotation +
                        Math.toDegrees(Math.atan2(x - centerX, centerY - y)).toFloat()
            }

            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    // cancel so we can grab the view during previous animation
                    rotationAnimation.cancel()

                    updateCurrentRotation()
                }
                MotionEvent.ACTION_MOVE -> {
                    // save current rotation
                    previousRotation = currentRotation

                    updateCurrentRotation()

                    // rotate view by angle difference
                    val angle = currentRotation - previousRotation
                    view.rotation += angle
                }
                MotionEvent.ACTION_UP -> rotationAnimation.start()
            }
            true
        }
    }

    fun createSpringAnimation(
        view: View,
        property: DynamicAnimation.ViewProperty,
        finalPosition: Float,
        stiffness: Float,
        dampingRatio: Float
    ): SpringAnimation {
        val animation = SpringAnimation(view, property)
        val spring = SpringForce(finalPosition)
        spring.stiffness = stiffness
        spring.dampingRatio = dampingRatio
        animation.spring = spring
        return animation
    }
}
