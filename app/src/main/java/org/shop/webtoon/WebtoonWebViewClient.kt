package org.shop.webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(private val progressBar: ProgressBar) : WebViewClient() {

//    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//        return !(request != null && request.url.toString().contains("comic.naver.com"))
//    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        progressBar.visibility = View.VISIBLE
    }

    // 생략
//    override fun onReceivedError(
//        view: WebView?,
//        request: WebResourceRequest?,
//        error: WebResourceError?
//    ) {
//        super.onReceivedError(view, request, error)
//
//        // 에러페이지를 띄워주거나 하는 작엄..
//    }
}