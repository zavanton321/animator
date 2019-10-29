package com.example.animator.animated_vector

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_animated_vector_drawable.*

class AnimatedVectorDrawableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_vector_drawable)

        val animatedVectorDrawable = tvDemo.drawable as AnimatedVectorDrawable

        tvDemo.setOnClickListener {
            animatedVectorDrawable.start()
        }
    }
}
