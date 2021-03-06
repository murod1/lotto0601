package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

fun getLottoNumbersFromHash(str:String):MutableList<Int>{
    val list = mutableListOf<Int>()

    for (number in 1..45){
        list.add(number)
    }
    val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS",
            Locale.KOREA).format(Date()) + str

    list.shuffle(Random(targetString.hashCode().toLong()))
    return list.subList(0,6)
}

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoResult = findViewById<Button>(R.id.goResultButton)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val txtConstell = findViewById<TextView>(R.id.textView)
        val calender = Calendar.getInstance()

        txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
        datePicker.init(calender.get(Calendar.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH)
        ,object : CalendarView.OnDateChangeListener,DatePicker.OnDateChangedListener{
            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                TODO("Not yet implemented")
            }

            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                txtConstell.text = makeConstellationString(datePicker.month,datePicker.dayOfMonth)
            }

        }
        )

        btnGoResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))
            intent.putExtra("constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }

    private fun makeConstellationString(month: Int, day: Int): String {
        val target = "${month+1}${String.format("%02d", day)}".toInt()
        when (target) {
            in 101..119 -> return "????????????"
            in 120..218 -> return "????????????"
            in 219..320 -> return "???????????????"
            in 321..419 -> return "?????????"
            in 420..520 -> return "????????????"
            in 521..621 -> return  "???????????????"
            in 622..722 -> return "?????????"
            in 723..822 -> return "????????????"
            in 823..923 -> return "????????????"
            in 924..1022 -> return "????????????"
            in 1023..1122 -> return "????????????"
            in 1123..1224 -> return "????????????"
            in 1225..1231 -> return "????????????"
            else -> return "???????????????"
        }
        return "A"
    }
}