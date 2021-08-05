package com.example.viewpagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpagerview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textList = listOf("뷰A","뷰B","뷰C","뷰D") //뷰페이지에서 사용할 데이터를 가상으로 생성한 후 textList변수에 담음

        val customAdapter = CustomPagerAdapter()  //커스텀 어댑터 생성.

        customAdapter.textList=textList  //생성해둔 가상 데이터를 어댑터에 전달.

        binding.viewPager.adapter = customAdapter //viewPager에 어댑터 연결.

        val tabTitles=listOf("View A","View B","View C","View D")
        //배열에 메뉴명으로 사용할 이름들을 저장.

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            tab.text =tabTitles[position]
        }.attach()
    }
}