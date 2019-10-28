package com.example.animator.circular_reveal

import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_circular_reveal.*
import kotlinx.android.synthetic.main.activity_vector.*
import kotlin.math.hypot

class CircularRevealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_reveal)

        btnShow.setOnClickListener {
            revealImage()
        }
    }

    private fun revealImage() {

        val centerX = ivAvatar.width / 2
        val centerY = ivAvatar.height / 2
        val finalRadius = hypot(
            centerX.toDouble(),
            centerY.toDouble()
        ).toFloat()

        val animator =
            ViewAnimationUtils.createCircularReveal(ivAvatar, centerX, centerY, 0f, finalRadius)

        ivAvatar.visibility = View.VISIBLE

        animator.start()
    }
}
