package com.example.animator.fling

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.FlingAnimation
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_move.*

class MoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val flingAnimationX = FlingAnimation(ivDemo, FlingAnimation.X)
        flingAnimationX.friction = 1.2F

        val flingAnimationY = FlingAnimation(ivDemo, FlingAnimation.Y)
        flingAnimationY.friction = 1.2F

        val listener = object : GestureDetector.SimpleOnGestureListener() {

            override fun onFling(
                motionEvent1: MotionEvent,
                motionEvent2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {

                flingAnimationX.setStartVelocity(velocityX)
                flingAnimationY.setStartVelocity(velocityY)

                flingAnimationX.start()
                flingAnimationY.start()

                return true
            }
        }

        val detector = GestureDetector(this, listener)

        ivDemo.setOnTouchListener { _, event ->
            detector.onTouchEvent(event)
            true
        }
    }
}
