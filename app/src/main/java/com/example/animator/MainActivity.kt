package com.example.animator

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDemo.setOnClickListener {

            // animateWithValueAnimator()
            // animateWithObjectAnimator()
            animateWithViewPropertyAnimator()
        }
    }

    private fun animateWithValueAnimator() {
        val valueAnimator = ValueAnimator.ofFloat(1F, 0F)
        valueAnimator.addUpdateListener { animator ->
            tvDemo.alpha = animator.animatedValue as Float
        }
        valueAnimator.duration = 500
        valueAnimator.start()
    }

    private fun animateWithObjectAnimator() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "alpha", 1F, 0F)
        objectAnimator.duration = 500
        objectAnimator.start()
    }

    private fun animateWithViewPropertyAnimator() {
        tvDemo.animate()
            .alpha(0F)
            .setDuration(500)
            .start()
    }
}
