package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result") ?: return
        val strConstellation = intent.getStringExtra("constellation")
        strConstellation?.let {
            val resultLabel = findViewById<TextView>(R.id.resultLable)
            resultLabel.text = "${strConstellation}의 ${SimpleDateFormat("yyyy년 MM월 dd일").format((Date()))}"
        }
      //  if(result == null){
       //     return
      // }
       // println("result is $result")
        //result.sort()
        //println("result sorted is $result")

        result?.let{
            updateLottoBallIamges(result.sorted())
        }

        //println(result_sorted)
        Toast.makeText(this,"Result ACtivity", Toast.LENGTH_LONG).show()




    }

    private fun updateLottoBallIamges(resultSorted: List<Int>) {
        val lottoBallImageStartId = R.drawable.ball_01
        //  val lottoBallImageStartId2 = R.drawable.ball_02
        val ImageView1 = findViewById<ImageView>(R.id.num1)
        val ImageView2 = findViewById<ImageView>(R.id.num2)
        val ImageView3 = findViewById<ImageView>(R.id.num3)
        val ImageView4 = findViewById<ImageView>(R.id.num4)
        val ImageView5 = findViewById<ImageView>(R.id.num5)
        val ImageView6 = findViewById<ImageView>(R.id.num6)

        ImageView1.setImageResource(lottoBallImageStartId + resultSorted!![0] -1)
        ImageView2.setImageResource(lottoBallImageStartId + resultSorted[1] -1)
        ImageView3.setImageResource(lottoBallImageStartId + resultSorted[2] -1)
        ImageView4.setImageResource(lottoBallImageStartId + resultSorted[3] -1)
        ImageView5.setImageResource(lottoBallImageStartId + resultSorted[4] -1)
        ImageView6.setImageResource(lottoBallImageStartId + resultSorted[5] -1)
        println(resultSorted)
    }

}