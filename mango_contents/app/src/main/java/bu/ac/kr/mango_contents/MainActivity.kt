package bu.ac.kr.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mfwd78vEtS",
                "https://mp-seoul-image-production-s3.mangoplate.com/13936/704481_1492338122499_12072?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "파씨오네"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/fPi6OZ3r-u",
                "https://mp-seoul-image-production-s3.mangoplate.com/516929_1525669069306497.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "비야게레로"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/08OQhkbuBywp",
            "https://mp-seoul-image-production-s3.mangoplate.com/806970_1500088411444579.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "팬케이크"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mfwd78vEtS",
                "https://mp-seoul-image-production-s3.mangoplate.com/13936/704481_1492338122499_12072?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "파씨오네"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/fPi6OZ3r-u",
                "https://mp-seoul-image-production-s3.mangoplate.com/516929_1525669069306497.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비야게레로"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/08OQhkbuBywp",
                "https://mp-seoul-image-production-s3.mangoplate.com/806970_1500088411444579.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "팬케이크"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick= object : RVAdapter.ItemClick{
            override fun onClick(view : View, position:Int){

                val intent = Intent(baseContext,ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("imageUrl",items[position].ImageUrl)
                startActivity(intent)


            }
        }
        recyclerview.layoutManager = GridLayoutManager(this,2)

    }
}