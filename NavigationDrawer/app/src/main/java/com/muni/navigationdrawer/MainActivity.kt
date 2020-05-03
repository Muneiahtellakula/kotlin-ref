package com.muni.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar : Toolbar
    lateinit var navigationView:NavigationView
    lateinit var drawerlayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        navigationView = findViewById(R.id.navigation_view)
        drawerlayout = findViewById(R.id.drawerlayout)
        val toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar
            ,0,0)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        var fragment = FragmentRed()
        when(item.itemId)
        {
            R.id.wlak_id -> {
                fragment = FragmentRed()
            }
            R.id.edit -> {

            }
        }
        ft.replace(R.id.contentspace,fragment)
        ft.commit()
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

}