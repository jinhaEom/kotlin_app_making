package bu.ac.kr.smartphone_ranking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bu.ac.kr.smartphone_ranking.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var smartPhoneList = arrayListOf<SmartPhone>(
        SmartPhone("1위", "갤럭시Z플립3", "galaxyzflip3"),
        SmartPhone("2위", "갤럭시폴드3", "galaxyfold3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smartphoneAdapter = ListViewAdapter(this, smartPhoneList)
        ListViewAdapter.adapter = smartphoneAdapter


    }
}