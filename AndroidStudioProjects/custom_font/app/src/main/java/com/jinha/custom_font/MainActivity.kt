package com.jinha.custom_font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_item = mutableListOf<ListViewModel>()


        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        val listView= findViewById<ListView>(R.id.mainListView)
        val listAdapter = ListViewAdapter(list_item)
        listView.adapter = listAdapter



    }
}