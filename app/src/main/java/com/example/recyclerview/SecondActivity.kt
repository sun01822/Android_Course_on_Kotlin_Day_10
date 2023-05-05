package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class SecondActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.name)
        textView2 = findViewById(R.id.phone)

        getData()
    }
    private fun getData() {
        textView.text = intent.getStringExtra("name")
        textView2.text = intent.getStringExtra("number")
        val imageLink = intent.getStringExtra("profile")
        Glide.with(this).load(imageLink).into(imageView)
    }
}