package com.jinha.custom_font

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter(){
    override fun getCount(): Int { //리스트뷰의 갯수
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
        }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var converView = convertView

        if(converView ==null){
            converView=LayoutInflater.from(parent?.context).inflate(R.layout.listview_item,parent,false)
        }
        val title = converView!!.findViewById<TextView>(R.id.listviewItem)
        val content = converView!!.findViewById<TextView>(R.id.listviewItem2)
        title.text=List[position].title
        content.text=List[position].content
        return convertView!!
    }

}