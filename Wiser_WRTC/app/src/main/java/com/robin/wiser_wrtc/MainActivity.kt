package com.robin.wiser_wrtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.robin.wiser_wrtc.databinding.ActivityMainBinding
import com.robin.wiser_wrtc.main.DashboardFragment
import com.robin.wiser_wrtc.main.SettingsContainerFragment
import com.robin.wiser_wrtc.util.requestPermissions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)

        val tabLayout = binding.tabLayoutMain
        tabLayout.addOnTabSelectedListener(onTabSelectedListener)

        val viewPager2 = binding.viewPagerMain
        viewPager2.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            val iconResourceId = when (position) {
                0 -> R.drawable.icon_rooms
                1 -> R.drawable.icon_settings
                else -> return@TabLayoutMediator
            }

            tab.setIcon(iconResourceId)
        }.attach()
        requestPermissions()
    }

    private val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> tab.setIcon(R.drawable.icon_rooms_filled)
                1 -> tab.setIcon(R.drawable.icon_settings_filled)
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> tab.setIcon(R.drawable.icon_rooms_grey)
                1 -> tab.setIcon(R.drawable.icon_settings_grey)
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }

    inner class ViewPagerAdapter(
        fragmentActivity: FragmentActivity
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> DashboardFragment()
                1 -> SettingsContainerFragment()
                else -> throw IndexOutOfBoundsException()
            }
        }
    }
}