package bu.ac.kr.smartphone_ranking

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var smartPhoneList = arrayListOf<SmartPhone>(

        SmartPhone("1위", "갤럭시Z플립3", "galaxyzfip3"),
        SmartPhone("2위", "갤럭시폴더3", "galaxyfold3"),
        SmartPhone("3위","갤럭시S21","galaxy21")
    )
    var mainListView = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listview = findViewById<ListView>(R.id.mainListView)
        val smartPhoneAdapter = MainListAdapter(this, smartPhoneList)
        listview.adapter = smartPhoneAdapter

    }
}