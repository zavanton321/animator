package com.example.animator.crossfade

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_cross_fade.*

class CrossFadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cross_fade)

        crossFade()
    }

    private fun crossFade() {
        hideLoadingIndicator()
        revealTextContent()
    }

    private fun hideLoadingIndicator() {
        vProgressBar.animate()
            .alpha(0F)
            .setDuration(500)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    vProgressBar.visibility = View.GONE
                }
            })
            .start()
    }

    private fun revealTextContent() {
        vScrollView.visibility = View.VISIBLE
        vScrollView.alpha = 0F
        vScrollView.animate()
            .alpha(1F)
            .setDuration(500)
            .start()
    }
}
