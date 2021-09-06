package bu.ac.kr.smartphone_ranking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MainListAdapter(val context: Context, val smartPhoneList: ArrayList<SmartPhone>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return smartPhoneList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return smartPhoneList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView =convertView

        if(convertView==null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item,parent,false)

        }


        val phoneImg = convertView!!.findViewById<ImageView>(R.id.phoneImg)
        val phoneName = convertView!!.findViewById<TextView>(R.id.phoneName)
        val phoneRanking = convertView!!.findViewById<TextView>(R.id.phoneRanking)

        val phone = smartPhoneList[position]
        val resourceId = context.resources.getIdentifier(phone.photo,"drawable",context.packageName)
        phoneImg.setImageResource(resourceId)
        phoneName.text= phone.name
        phoneRanking.text=phone.ranking


        return convertView!!
    }




}