package bu.ac.kr.smartphone_ranking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(val context: Context, val smartPhoneList: ArrayList<SmartPhone>) :
    BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val phoneImg = view.findViewById<ImageView>(R.id.phoneImg)
        val phoneName = view.findViewById<TextView>(R.id.phoneName)
        val phoneRanking = view.findViewById<TextView>(R.id.phoneRanking)

        val phone = smartPhoneList[position]
        val resourceId = context.resources.getIdentifier(phone.photo,"drawable",context.packageName)
        phoneImg.setImageResource(resourceId)
        phoneName.text= phone.name
        phoneRanking.text=phone.ranking

        return view
    }

    override fun getCount(): Int {
        return smartPhoneList.size
    }

    override fun getItem(position: Int): Any {
        return smartPhoneList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


}