package com.example.coroutine_ex

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.View
import com.example.coroutine_ex.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

suspend fun loadImage(imageUrl: String): Bitmap {  //class 코드 밖 Top-Level에 함수작성과 suspend키워드를 통해 코루틴으로 만들어줌.
    val url = URL(imageUrl)
    val stream = url.openStream()
    return BitmapFactory.decodeStream(stream)
}

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.run {       //binding 처리를 run으로 감싸면 반복되는 binding. 을 제거 가능.
            binding.buttonDownload.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    binding.progress.visibility = View.VISIBLE
                    val url = binding.editUrl.text.toString()
                    val bitmap = withContext(Dispatchers.IO) {
                        loadImage(url)

                    }

                    binding.imagePreview.setImageBitmap(bitmap)
                    binding.progress.visibility = View.GONE
                }
            }
        }

    }
}