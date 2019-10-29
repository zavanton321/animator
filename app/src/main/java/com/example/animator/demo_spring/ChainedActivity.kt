package com.example.animator.demo_spring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_chained.*

class ChainedActivity : AppCompatActivity() {

    private var diffX = 0.0F
    private var diffY = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chained)


        ivRed.setOnTouchListener(object : View.OnTouchListener {

            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {

                when (motionEvent.action) {

                    MotionEvent.ACTION_DOWN ->  {
                        diffX = motionEvent.rawX - view.x
                        diffY = motionEvent.rawY - view.y
                    }

                    MotionEvent.ACTION_MOVE -> {
                        view.animate()
                            .x(motionEvent.rawX - diffX)
                            .y(motionEvent.rawY - diffY)
                            .setDuration(0)
                            .start()
                    }
                }

                return true
            }
        })
    }
}
