package org.shop.webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(private val progressBar: ProgressBar, private val saveData: (String) -> Unit) :
    WebViewClient() {

    /** @see
     *  shouldOverrideUrlLoading은 url을 로드하려고 할 때 호출된다
     *  그때의 request를 검사하는데 그 request가 comic.naver.com/webtoon/detail을 포함하고 있으면 saveData 함수를 호출해서
     *  WebtoonWebViewClient를 만들어준 Fragment에서 실행된다
     */
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        // https://comic.naver.com/webtoon/detail?titleId=783052&no=114&week=mon
        if (request != null && request.url.toString().contains("comic.naver.com/webtoon/detail")) {
            /** @see
             *  Fragment, Activity 도 없는데 SharedPreference에 저장하는 3가지 방법
             *  1. 위에 ProgressBar 처럼 Fragment 자체를 주입받아서 Fragment에서 Activity 찾고, Activity에 있는 SharedPreference에 저장한다
             *  2. SharedPreference 자체를 받아서 해당 SharedPreference에 직접 주입한다
             *  3. SharedPreference에 저장하는 함수 자체를 받아서 여기서 실행한다
             */
            saveData(request.url.toString())
        }
        return super.shouldOverrideUrlLoading(view, request)
    }

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