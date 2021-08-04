package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customView = CustomView("안녕코틀린?",this)
        binding.frameLayout.addView(customView)
    }
    class CustomView(text: String, context: Context): View(context){
        //canvas 는 일종의 그리기 도구로, 그림판과 함꼐 그림을 그리기 위해 draw로 시작하는 메서드들이 제공됌.
        val text : String
        init{
            this.text = text
        }
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.color = Color.BLACK
            paint.textSize=100f  //값의 타입이 float형이기 때문에 f 추가기입
            canvas?.drawText("안녕하세요?",0f,100f,paint)
        }
    }
}