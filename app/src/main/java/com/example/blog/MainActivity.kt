package com.example.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.blog.adapter.RecycerViewDetail
import com.example.blog.databinding.ActivityMainBinding
import com.example.blog.model.UserDetail
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.blog.ui.fragments.ShowListFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{
    lateinit var binding: ActivityMainBinding
    lateinit var toggle :ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//      setSupportActionBar(binding.toolbar)

        populatingNavBar()
        populatingHorizontalList()
        toggelSetInDrawable()

//        set notification count
        binding.nav.setCount(1, "10")
        binding.nav.show(2, true)

        binding.nav.setOnClickMenuListener {
//            Toast.makeText(applicationContext, "you click" + it.id, Toast.LENGTH_SHORT).show()
        }
    }

    private fun populatingNavBar() {
        binding.nav.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_house_24))
        binding.nav.add(MeowBottomNavigation.Model(2, R.drawable.menu))
        binding.nav.add(MeowBottomNavigation.Model(3, R.drawable.search))
        binding.nav.add(MeowBottomNavigation.Model(4, R.drawable.sqr))

        binding.nav.setOnShowListener {
            when (it.id) {
                1 -> Toast.makeText(applicationContext, "House", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext, "Menu", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext, "search", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext, "sqr", Toast.LENGTH_SHORT).show()
                else -> {
//                    Toast.makeText(applicationContext, "else", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun populatingHorizontalList() {
        //fake data
        var arrayData = ArrayList<UserDetail>()
        arrayData.add(UserDetail(R.drawable.per1, "Deep", "Noob", "Web Dev", 555))
        arrayData.add(UserDetail(R.drawable.per2, "Avinash", "Pro", "Android Dev", 222))
        arrayData.add(UserDetail(R.drawable.per3, "jeys", "Moderate", "Entrepreneur", 559))

        binding.rv.layoutManager = LinearLayoutManager(this)
        val recyAdapter = RecycerViewDetail(arrayData, this)
        binding.rv.adapter = recyAdapter
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_settings -> {
                Toast.makeText(this, "setting clicked", Toast.LENGTH_SHORT).show()
                binding.myDrawerLayout.closeDrawers()
//                fragLayout(ShowListFragment())
            }
            R.id.nav_account -> {}
                R.id.nav_logout ->{}

            else -> "On Nav"
        }
        return true
    }
    fun fragLayout(frag : Fragment){
        var fragManager = supportFragmentManager
        var ft =fragManager.beginTransaction()
//        ft.replace(R.id.fragHost,frag)
        ft.commit()
    }
    private fun toggelSetInDrawable(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle = ActionBarDrawerToggle(this,
            binding.myDrawerLayout,
            R.string.nav_open,
            R.string.nav_close)
        binding.myDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navMainSide.bringToFront()
        binding.navMainSide.setNavigationItemSelectedListener(this)
    }

}