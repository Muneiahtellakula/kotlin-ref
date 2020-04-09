package com.muni.mytabnav





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
lateinit var viewvp:ViewPager
   lateinit var tabl:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewvp=findViewById(R.id.vp)
        tabl=findViewById(R.id.tab)
        val vpa: ViewpagerAdapter=ViewpagerAdapter(supportFragmentManager,3)
      viewvp.adapter=vpa
        tabl.setupWithViewPager(viewvp)
        //tabl.addOnTabSelectedListener(TabHost.OnTabChangeListener)

    }
    class ViewpagerAdapter(fm:FragmentManager,v:Int):FragmentStatePagerAdapter(fm,v){

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0->return "First"
                1->return "Second"
                2->return "Third"
            }
            return super.getPageTitle(position)

        }
        override fun getCount(): Int {
            return  3
            //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(position: Int): Fragment {
            when(position){
                0->return First()
                1->return SecondFragment()
                2->return SecondFragment()
            }
          //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return null!!
        }

    }
}
