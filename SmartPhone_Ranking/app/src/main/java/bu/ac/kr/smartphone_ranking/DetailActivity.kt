package bu.ac.kr.smartphone_ranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val getData = intent.getStringExtra("data")

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        // Toast.makeText(this, getData, Toast.LENGTH_LONG).show()

        if(getData == "1"){
            memberImage.setImageResource(R.drawable.zflip3info)
        }

        if(getData == "2") {
            memberImage.setImageResource(R.drawable.fold3info)
        }

        if(getData == "3") {
            memberImage.setImageResource(R.drawable.zflip3info)
        }
    }
}