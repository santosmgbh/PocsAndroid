package com.boleuti.animatedapplication

import android.animation.AnimatorInflater
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.ivAnimated)
        val bUpArrow = findViewById<Button>(R.id.bUpArrow)
        val bDownArrow = findViewById<Button>(R.id.bDownArrow)
        val bVectorAnimator = findViewById<Button>(R.id.bVectorAnimator)
        val bRotateArrow = findViewById<Button>(R.id.bRotateArrow)
        val bRotateArrowDown = findViewById<Button>(R.id.bRotateArrowDown)
        val bLaunchRocket = findViewById<Button>(R.id.bLaunchRocket)
        bUpArrow.setOnClickListener {
            imageView.setImageResource(R.drawable.animated_arrow_up)
            val animationDrawable = imageView.drawable as AnimationDrawable
            animationDrawable.start()
        }
        bDownArrow.setOnClickListener {
            imageView.setImageResource(R.drawable.animated_arrow_down)
            val animationDrawable = imageView.drawable as AnimationDrawable
            animationDrawable.start()
        }
        bVectorAnimator.setOnClickListener {
            imageView.setImageResource(R.drawable.animator_vector_drawable)
            val animationDrawable = imageView.drawable as AnimatedVectorDrawable
            animationDrawable.start()
        }
        bRotateArrow.setOnClickListener {
            imageView.setImageResource(R.drawable.arrow_down)
            val animation = AnimatorInflater.loadAnimator(this, R.animator.rotate_arrow_up)
            animation.setTarget(imageView)
            animation.start()
        }
        bRotateArrowDown.setOnClickListener {
            imageView.setImageResource(R.drawable.arrow_down)
            val animation = AnimatorInflater.loadAnimator(this, R.animator.rotate_arrow_down)
            animation.setTarget(imageView)
            animation.start()
        }
        bLaunchRocket.setOnClickListener {
            val rocket = findViewById<ImageView>(R.id.ivRocket)
            val animationIgnition = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump)
            val animationLaunch = AnimatorInflater.loadAnimator(this, R.animator.launch_rocket)
            rocket.startAnimation(animationIgnition)
//            animationLaunch.setTarget(rocket)
//            animationLaunch.start()
        }
    }
}