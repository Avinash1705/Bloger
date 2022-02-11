package com.example.blog.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import com.example.blog.R
import com.example.blog.databinding.ActivityDrawableTestBinding
import com.google.android.material.navigation.NavigationView

class DrawableTestActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{
    lateinit var binding :ActivityDrawableTestBinding
    lateinit var toggle :ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_drawable_test)
        setActionBar()
        binding.navTestSide.setNavigationItemSelectedListener(this)
    }
   private fun setActionBar(){
        supportActionBar!!.setHomeButtonEnabled(true)
        toggle = ActionBarDrawerToggle(this,binding.dlTest,R.string.nav_open,R.string.nav_close)
        binding.dlTest.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.nav_account -> Toast.makeText(this, "Test Activity", Toast.LENGTH_SHORT).show()
       }
        return true
    }
}