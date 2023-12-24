package org.shop.webtoon

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import org.shop.webtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnTabLayoutNameChanged {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val sharedPreference =
            getSharedPreferences(WebViewFragment.SHARED_PREFERENCE, Context.MODE_PRIVATE)
        val tab0 = sharedPreference?.getString("tab0_name", "퀘스트지상주의")
        val tab1 = sharedPreference?.getString("tab1_name", "금요 웹툰")
        val tab2 = sharedPreference?.getString("tab2_name", "일요 웹툰")


        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            run {
//                val textView = TextView(this@MainActivity)
//                textView.text = "position $position"
//                textView.gravity = Gravity.CENTER
//
//                tab.customView = textView
                tab.text = when (position) {
                    0 -> tab0
                    1 -> tab1
                    else -> tab2
                }
            }
        }.attach()
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments[binding.viewPager.currentItem]
        Log.d("MainActivity BackPressed", currentFragment.toString())
        if (currentFragment is WebViewFragment) {
            if (currentFragment.canGoBack()) {
                currentFragment.goBack()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun nameChanged(position: Int, name: String) {
        val tab = binding.tabLayout.getTabAt(position)
        tab?.text = name
    }
}