package org.shop.webtoon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity) :
    FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                WebViewFragment(
                    position,
                    "https://comic.naver.com/webtoon/detail?titleId=783052&no=114&week=mon"
                ).apply { listener = mainActivity }
            }

            1 -> {
                WebViewFragment(
                    position,
                    "https://comic.naver.com/webtoon?tab=fri"
                ).apply { listener = mainActivity }
            }

            else -> {
                WebViewFragment(
                    position,
                    "https://comic.naver.com/webtoon?tab=sun"
                ).apply { listener = mainActivity }
            }
        }
    }
}