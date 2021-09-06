package bu.ac.kr.smartphone_ranking

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bu.ac.kr.smartphone_ranking.databinding.ActivityDetailBinding.inflate

import java.util.zip.Inflater


class MainActivity : AppCompatActivity() {

    var smartPhoneList = arrayListOf<SmartPhone>(

        SmartPhone("1위", "갤럭시Z플립3", "galaxyzfip3"),
        SmartPhone("2위", "갤럭시폴더3", "galaxyfold3"),
        SmartPhone("3위","갤럭시S21","galaxy21"),
        SmartPhone("4위","갤럭시S21","galaxy21"),
        SmartPhone("5위","갤럭시S21","galaxy21")

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.mainListView)
        val smartPhoneAdapter = MainListAdapter(this, smartPhoneList)
        listview.adapter = smartPhoneAdapter

        listview.onItemClickListener= AdapterView.OnItemClickListener{ parent, v, position, id ->

                intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://image.news1.kr/system/photos/2020/9/1/4363040/article.jpg/dims/optimize"));
                startActivity(intent)



        }

    }



}
