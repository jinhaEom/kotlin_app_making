package com.example.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Singer3Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer3, container, false)

        val items = mutableListOf<String>()
        items.add("내 마음의 사진")
        items.add("서울의 달")
        items.add("엄마아리랑")
        items.add("무명배우")
        items.add("가인이어라")
        items.add("한 많은 대동강")
        items.add("트로트가 나는 좋아요")
        items.add("용두산 엘레지")
        items.add("이별으 영동선")
        items.add("금지된 사랑")
        items.add("진실 혹은 대담")
        items.add("찍어")
        items.add("거문고야")
        items.add("사랑에 빠져봅시다")
        items.add("Tears")
        items.add("어머님 사랑합니다")
        items.add("단장의 미아리 고개")
        

        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)


        view.findViewById<ImageView>(R.id.image1).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer1Fragment)
        }

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer2Fragment)
        }

        return view
    }


}