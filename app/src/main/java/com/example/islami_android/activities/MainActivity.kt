package com.example.islami_android.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami_android.R
import com.example.islami_android.fragments.HadethFragment
import com.example.islami_android.fragments.QuranFragment
import com.example.islami_android.fragments.RadioFragment
import com.example.islami_android.fragments.TasbeehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }
    private fun initViews(){
        bottomNavigationView = findViewById(R.id.islami_bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.navigation_quran -> pushFragment(QuranFragment())
                R.id.navigation_hadeth -> pushFragment(HadethFragment())
                R.id.navigation_sebha -> pushFragment(TasbeehFragment())
                R.id.navigation_radio -> pushFragment(RadioFragment())

            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.navigation_quran
    }
    fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.islami_fragment_container, fragment)
            .commit()
    }
}