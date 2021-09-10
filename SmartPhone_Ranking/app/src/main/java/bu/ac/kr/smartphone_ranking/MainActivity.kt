package bu.ac.kr.smartphone_ranking

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import bu.ac.kr.smartphone_ranking.databinding.ActivityDetailBinding.inflate

import java.util.zip.Inflater


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn1 = findViewById<ImageView>(R.id.phone1)
        val btn2 = findViewById<ImageView>(R.id.phone2)
        val btn3 = findViewById<ImageView>(R.id.phone3)


        btn1.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data", "1")
            startActivity(intent)

        }
        btn2.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data", "2")
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data", "3")
            startActivity(intent)
        }


    }
}



