package com.example.animator.listeners

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_main.*

class ListenersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listeners)

        tvDemo.setOnClickListener {

            // animateWithInterpolator()
            // animateWithAnimatorListener()
            // animateWithAnimatorListenerAdapter()
            // animateWithUpdateListener()
            animateWithPauseListener()
        }
    }

    private fun animateWithInterpolator() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.interpolator = AccelerateDecelerateInterpolator()
        objectAnimator.duration = 1000
        objectAnimator.start()
    }

    private fun animateWithAnimatorListener() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.duration = 1000

        objectAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(this@ListenersActivity, "Animation Start", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Toast.makeText(this@ListenersActivity, "Animation Repeat", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(this@ListenersActivity, "Animation End", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator?) {
                Toast.makeText(this@ListenersActivity, "Animation Cancel", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        objectAnimator.start()
    }

    private fun animateWithAnimatorListenerAdapter() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.duration = 1000

        objectAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(this@ListenersActivity, "Animation Start", Toast.LENGTH_SHORT).show()
            }
        })

        objectAnimator.start()
    }

    private fun animateWithUpdateListener() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.duration = 1000

        objectAnimator.addUpdateListener { animation ->
            Log.d("zavanton", "zavanton: ${animation.animatedValue as Float}")
        }

        objectAnimator.start()
    }

    private fun animateWithPauseListener() {
        val objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 200F)
        objectAnimator.duration = 1000

        objectAnimator.addPauseListener(object : Animator.AnimatorPauseListener {
            override fun onAnimationPause(animation: Animator) {
                Toast.makeText(this@ListenersActivity, "Animation Paused", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAnimationResume(animation: Animator) {
                Toast.makeText(this@ListenersActivity, "Animation Resumed", Toast.LENGTH_SHORT)
                    .show()
            }

        })

        objectAnimator.start()
    }
}
