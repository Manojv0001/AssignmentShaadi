package com.example.assignmentshaadi.views

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.assignmentshaadi.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceFragment(HomeFragment.newInstance())
        bottom_navigation_view.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                replaceFragment(HomeFragment.newInstance())
                return false
            }
            R.id.accepted -> {
                replaceFragment(AcceptedProfilesFragment.newInstance())
                return false
            }
            R.id.declined -> {
                replaceFragment(DeclinedProfilesFragment.newInstance())
                return false
            }
        }
        return true
    }
}