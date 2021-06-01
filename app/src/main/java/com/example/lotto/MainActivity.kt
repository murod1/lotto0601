package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    fun getRandomLottoNumber () : Int{
        return Random().nextInt(45)+1
    }
    fun getShuffledLottoNumbers () : MutableList<Int>{
        val list = mutableListOf<Int>()
        for(number in 1..45){
            list.add(number)
        }
        list.shuffle()
        return list.subList(0,6)
    }
    fun getRandomLottoNumbers() : MutableList<Int>{
        val lottoNumbers = mutableListOf<Int>()
        var flag_existing :Int =0
        while(true){
            var number : Int = getRandomLottoNumber()
          /*  for(j in 0..lottoNumbers.size){
                if(number.equals(lottoNumbers)){
                    flag_existing = 1
                    break;
                }
            }*/
            if(lottoNumbers.contains(number)){
              continue;
                //  flag_existing = 1
              //  break;
            }
           // if(flag_existing.equals(1))
              //  continue
          //  else
                lottoNumbers.add(number)
            if(lottoNumbers.size>=6)
                break;
        }
        return  lottoNumbers
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  NameCard = findViewById<CardView>(R.id.name)
        NameCard.setOnClickListener {
            startActivity(Intent( this, NameActivity::class.java))
        }
        val  Lottocard = findViewById<CardView>(R.id.lottoCard)
        Lottocard.setOnClickListener {
            var intent = Intent( this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
            }
        val  Constellcard = findViewById<CardView>(R.id.Constellation)
        Constellcard.setOnClickListener {
            startActivity(Intent( this, ConstellationActivity::class.java))
        }


    }
}