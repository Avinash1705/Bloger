package com.example.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.blog.adapter.RecycerViewDetail
import com.example.blog.databinding.ActivityMainBinding
import com.example.blog.model.UserDetail

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
//        supportActionBar?.hide()
        populatingNavBar()
        populatingHorizontalList()

        //set notification count
        binding.nav.setCount(1,"10")
        binding.nav.show(2,true)
        binding.nav.setOnClickMenuListener{
            Toast.makeText(applicationContext, "you click"+it.id, Toast.LENGTH_SHORT).show()
        }
        binding.nav.setOnReselectListener{
            Toast.makeText(applicationContext, "reselect"+it.id , Toast.LENGTH_SHORT).show()
        }

    }
    fun populatingNavBar(){
        binding.nav.add(MeowBottomNavigation.Model(1,R.drawable.ic_baseline_house_24))
        binding.nav.add(MeowBottomNavigation.Model(2,R.drawable.menu))
        binding.nav.add(MeowBottomNavigation.Model(3,R.drawable.search))
        binding.nav.add(MeowBottomNavigation.Model(4,R.drawable.sqr))

        binding.nav.setOnShowListener {
            when(it.id){
                1 -> Toast.makeText(applicationContext, "House", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext, "Menu", Toast.LENGTH_SHORT).show()
                3-> Toast.makeText(applicationContext, "search", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext, "sqr", Toast.LENGTH_SHORT).show()
                else ->{
                    Toast.makeText(applicationContext, "else", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun populatingHorizontalList(){
        //fake data
        var arrayData = ArrayList<UserDetail>()
        arrayData.add(UserDetail(R.drawable.per1,"Deep","Noob","Web Dev",555))
        arrayData.add(UserDetail(R.drawable.per2,"Avinash","Pro","Android Dev",222))
        arrayData.add(UserDetail(R.drawable.per3,"jeys","Moderate","Entrepreneur",559))

        binding.rv.layoutManager = LinearLayoutManager(this)
        val recyAdapter = RecycerViewDetail(arrayData,this)
        binding.rv.adapter = recyAdapter
    }
}