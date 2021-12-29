package com.example.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ViewBlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_blog)

        var intentDataGet = intent
        Toast.makeText(this, ""+ (intentDataGet.extras?.get("keyName") ?: "went worng"), Toast.LENGTH_SHORT).show()
    }
}