# WebToon
웹툰 앱
- ViewPager2를 이용하여 N개의 Fragment를 구성한다
- 각 Fragment는 WebView를 전체화면으로 구성한다
- TabLayout과 ViewPager2를 연동하고, Tab이름을 동적으로 바꿀 수 있다
- 웹툰의 마지막 조회 시점을 로컬에 저장하고, 앱 실행 시 불러온다

## WebView
  - WebViewClient를 통해 로딩이 시작 됐을 때, 로딩이 끝났을 때, url Request에 따른 제어 구현 가능
  - onPageStarted, onPageFinished, onReceivedError, shouldOverrideUrlLoading 등..

## [ViewPager2](https://developer.android.com/training/animation/screen-slide-2?hl=ko)
  - ViewPager2와 Fragment를 함께 쓰기
  - TabLayoutMediator를 통해 TabLayout과 연결
  - 하나의 전체화면에서 다른 전체화면으로 전환할 때 사용
  - 내부 구현은 RecyclerView로 이루어짐
  - ViewPager2 어댑터로 FragmentStateAdapter 사용

## [Fragment](https://developer.android.com/guide/components/fragments?hl=ko)
  - 액티비티의 모듈식 섹션
  - 자체적인 생명 주기를 가진다
  - 재사용가능

## SharedPreference
  - SharedPreference를 통해 마지막 URL, Tab Name 저장하기

## Dialog
  - dialog.setView를 통해 Dialog 내부 View를 동적으로 표현
