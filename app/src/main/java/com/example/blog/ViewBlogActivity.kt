package com.example.blog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.blog.databinding.ActivityViewBlogBinding

class ViewBlogActivity : AppCompatActivity() {
//    lateinit var dataLikes: TextView
//    lateinit var dataDes: TextView
//    lateinit var dataDesShort: TextView
//    lateinit var dataJob: TextView
//    lateinit var imgData: ImageView
    lateinit var binding: ActivityViewBlogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_blog)

        var intentDataGet = intent
        setIntentData(intentDataGet)
    }

    fun setIntentData(dataView: Intent) {
        Toast.makeText(
            this,
            "" + (dataView.extras?.get("keyName") ?: "went worng"),
            Toast.LENGTH_SHORT
        ).show()
        binding.tvNameView.text = dataView.extras?.get("keyName").toString()
        binding.tvDescView.text = dataView.extras?.get("keyDesc").toString()
        binding.tvJobView.text = dataView.extras?.get("keyJob").toString()
        binding.tvLikesView.text = dataView.extras?.get("keyLikes").toString()
        Glide.with(applicationContext).load(dataView.extras?.get("keyImg")).into(binding.ivBlogView)
    }
}