package com.danscoding.evenity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.danscoding.evenity.databinding.ActivityMainBinding
import com.danscoding.evenity.fragments.HomeFragment
import com.danscoding.evenity.fragments.MessageFragment
import com.danscoding.evenity.fragments.NotificationFragment
import com.danscoding.evenity.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val messageFragment = MessageFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_notification -> makeCurrentFragment(notificationFragment)
                R.id.navigation_message -> makeCurrentFragment(messageFragment)
                R.id.navigation_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }

}