package com.example.animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDemo.setOnClickListener {

            // animateWithValueAnimator()
            // animateWithObjectAnimator()
            // animateWithViewPropertyAnimator()
            // complexAnimationWithAnimatorSet()
            animateWithInterpolatorAndListener()
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

    private fun complexAnimationWithAnimatorSet() {
        val rightAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 100F)
        rightAnimator.duration = 250

        val downAnimator = ObjectAnimator.ofFloat(tvDemo, "translationY", 100F)
        downAnimator.duration = 250

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(rightAnimator, downAnimator)
        animatorSet.start()
    }

    private fun animateWithInterpolatorAndListener() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.interpolator = AccelerateDecelerateInterpolator()
        objectAnimator.duration = 1000

        objectAnimator.addUpdateListener { animation ->
            Log.d("zavanton", "zavanton: ${animation.animatedValue as Float}")
        }

        objectAnimator.start()
    }
}
