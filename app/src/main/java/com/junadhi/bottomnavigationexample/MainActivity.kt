package com.junadhi.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.junadhi.bottomnavigationexample.fragment.HomeFragment
import com.junadhi.bottomnavigationexample.fragment.NotificationFragment
import com.junadhi.bottomnavigationexample.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notificationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}