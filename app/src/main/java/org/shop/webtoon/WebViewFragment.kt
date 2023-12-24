package org.shop.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.shop.webtoon.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient = WebtoonWebViewClient(binding.progressBar)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://comic.naver.com/webtoon/detail?titleId=783052&no=114&week=mon")
    }

    fun canGoBack(): Boolean {
        return binding.webView.canGoBack()
    }

    fun goBack() {
        binding.webView.goBack()
    }
}