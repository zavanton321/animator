package com.example.animator.vector

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_vector.*

class VectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector)

        val animation = ivDemo.drawable as AnimatedVectorDrawable

        ivDemo.setOnClickListener {
            animation.start()
        }
    }
}
