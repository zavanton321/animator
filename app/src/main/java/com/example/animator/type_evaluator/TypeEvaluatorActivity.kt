package com.example.animator.type_evaluator

import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.animator.R
import kotlinx.android.synthetic.main.activity_main.*


class TypeEvaluatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_evaluator)

        showCounter(tvDemo, "300")
    }

    private fun showCounter(target: TextView, maxCountValue: String) {
        val valueAnimator = ValueAnimator()
        valueAnimator.setObjectValues("0", maxCountValue)

        valueAnimator.addUpdateListener { animation ->
            target.text = animation.animatedValue as String
        }


        valueAnimator.setEvaluator(object : TypeEvaluator<String> {
            override fun evaluate(fraction: Float, startValue: String, endValue: String): String {
                val start = Integer.valueOf(startValue)
                val end = Integer.valueOf(endValue)
                return (start + (end - start) * fraction).toString()
            }
        })

        valueAnimator.duration = 1000
        valueAnimator.start()
    }
}
