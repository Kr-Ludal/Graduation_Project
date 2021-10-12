package com.example.graduation_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduation_project.ui.bookmark.BookmarkFragment
import com.example.graduation_project.ui.contest.ContestFragment
import com.example.graduation_project.ui.home.HomeFragment
import com.example.graduation_project.ui.post.WriteFragment
import com.example.graduation_project.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentUser = Firebase.auth.currentUser
        if(currentUser == null) {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.hide()

        home_bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        val homeFragment= HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.home_fragment_frame,homeFragment).commit()
    }

    private val onBottomNavItemSelectedListener=BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.nav_home -> {
                val homeFragment= HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment_frame, homeFragment).commit()
            }
            R.id.nav_contest->{
                val contestFragment= ContestFragment()
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment_frame,contestFragment).commit()
            }
            R.id.nav_write->{
                val writeFragment= WriteFragment()
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment_frame,writeFragment).commit()
            }
            R.id.nav_bookmark->{
                val bookmarkFragment= BookmarkFragment()
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment_frame,bookmarkFragment).commit()
            }
            R.id.nav_profile->{
                val profileFragment= ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment_frame,profileFragment).commit()
            }
        }
        true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        home_bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        val homeFragment= HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.home_fragment_frame,homeFragment).commit()

    }

}