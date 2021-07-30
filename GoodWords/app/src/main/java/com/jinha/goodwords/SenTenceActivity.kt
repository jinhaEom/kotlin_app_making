package com.jinha.goodwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SenTenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("피할수 없으면 즐겨라.")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다")
        sentenceList.add("어리석은 자는 멀리서 행복을 찾고, 현명한 자는 자신의 발치에서 행복을 키워간다")
        sentenceList.add("내일은 내일의 태양이 뜬다.")
        sentenceList.add("오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아간다.")
        sentenceList.add("내가 꿈을 꾸고있을때 남은 꿈을이루고 있다.")
        sentenceList.add("자신감있는 표정을 지으면 자신감이 생긴다.")
        sentenceList.add("1퍼센트의 가능성, 그것이 나의 길이다.")

        val sentenceAdapter = ListViewAdapter(sentenceList)

        val listview = findViewById<ListView>(R.id.sentenceListView)

        listview.adapter=sentenceAdapter
    }
}