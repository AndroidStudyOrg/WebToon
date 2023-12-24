package org.shop.webtoon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.shop.webtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, WebViewFragment())
                commit()
            }
        }

        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, BFragment())
                commit()
            }
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments[0]
        Log.d("MainActivity BackPressed", currentFragment.toString())
        if(currentFragment is WebViewFragment){
            if (currentFragment.canGoBack()){
                currentFragment.goBack()
            }else{
                super.onBackPressed()
            }
        }else{
            super.onBackPressed()
        }
    }
}