package com.muneiah.appontabpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var  tabLayout:TabLayout
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tab_id)
        viewPager=findViewById(R.id.vp)
        val myViewPagerAdapter:MyViewPagerAdapter= MyViewPagerAdapter(supportFragmentManager,3)
        viewPager.adapter=myViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }
    class MyViewPagerAdapter(fm:FragmentManager,v:Int):FragmentStatePagerAdapter(fm,v){
        override fun getItem(position: Int): Fragment {
            when (position){
                0-> return FirstFragment()
                1-> return SecondFragment()
            }
            return  null!!
        }

        override fun getCount(): Int {
                        return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0-> return "first"
                1-> return "Second"
            }
            return super.getPageTitle(position)
        }

    }
}
