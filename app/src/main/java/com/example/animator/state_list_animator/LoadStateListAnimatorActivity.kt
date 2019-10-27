package com.example.animator.state_list_animator

import android.animation.AnimatorInflater
import android.animation.StateListAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_main.*

class LoadStateListAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_state_list_animator)

        loadStateListAnimatorFromResourceFile()
    }

    private fun loadStateListAnimatorFromResourceFile() {
        val animator: StateListAnimator =
            AnimatorInflater.loadStateListAnimator(
                this,
                R.animator.custom_state_list_animator
            )
        tvDemo.stateListAnimator = animator
    }
}
