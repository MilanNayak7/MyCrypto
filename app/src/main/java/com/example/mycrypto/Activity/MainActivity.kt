package com.example.mycrypto.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.mycrypto.Adapter.ViewPagerFragmentAdapter
import com.example.mycrypto.Fragment.AllCryptoFragment
import com.example.mycrypto.Fragment.FavouriteFragment
import com.example.mycrypto.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.allCryptoTab)

        val fragmentAdapter =ViewPagerFragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(AllCryptoFragment(),"Home")
        fragmentAdapter.addFragment(FavouriteFragment(),"Favourite")
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        val id = intent.getStringExtra("Data_id")



    }
}