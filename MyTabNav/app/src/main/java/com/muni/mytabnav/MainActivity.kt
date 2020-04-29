package com.muni.mytabnav


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var viewvp: ViewPager
    lateinit var tabl: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewvp = findViewById(R.id.vp)
        tabl = findViewById(R.id.tab)
        val vpa: ViewpagerAdapter = ViewpagerAdapter(supportFragmentManager, 2)
        viewvp.adapter = vpa
        tabl.setupWithViewPager(viewvp)
        configureTabLayout()
        tabl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "selected:" + tab!!.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "Unselected:" + tab!!.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "Reselected:" + tab!!.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

    }

    class ViewpagerAdapter(fm: FragmentManager, v: Int) : FragmentStatePagerAdapter(fm, v) {

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "First"
                1 -> return "Second"

            }
            return super.getPageTitle(position)

        }

        override fun getCount(): Int {
            return 3
            //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return First()
                1 -> return SecondFragment()
                2 -> return SecondFragment()
            }
            //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return null!!
        }

    }

    private fun configureTabLayout() {

        tabl.addTab(
            tabl.newTab().setIcon(
                android.R.drawable.ic_dialog_email
            )
        )
        tabl.addTab(
            tabl.newTab().setIcon(
                android.R.drawable.ic_dialog_dialer
            )
        )
        tabl.addTab(
            tabl.newTab().setIcon(
                android.R.drawable.ic_dialog_map
            )
        )

    }
}
