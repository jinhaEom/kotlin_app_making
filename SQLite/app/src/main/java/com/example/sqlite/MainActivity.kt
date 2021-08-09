package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    val helper = SqliteHelper(this,"memo",1)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = RecyclerAdapter()
        adapter.helper=helper
        adapter.listData.addAll(helper.selectMemo()) //adapter listData에 db에서 가져온 데이터를 세팅.
        binding.recyclerMemo.adapter=adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)
        //화면의 리사이클러뷰 위젯에 adapter를 연결하고 레이아웃 매니저를 설정함.

        binding.buttonSave.setOnClickListener {
            if(binding.editMemo.text.toString().isNotEmpty()){
                val memo = Memo(null, binding.editMemo.text.toString(),System.currentTimeMillis())
                helper.insertMemo(memo)
                adapter.listData.clear()

                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()

                binding.editMemo.setText("")
            }
        }
    }
}