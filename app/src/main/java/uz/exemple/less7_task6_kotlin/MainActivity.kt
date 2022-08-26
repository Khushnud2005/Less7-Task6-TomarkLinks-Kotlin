package uz.exemple.less7_task6_kotlin

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
        val text = "I would like https://twitter.com, to do something similar to the https://twitter.com app"
        val tv = findViewById<TextView>(R.id.textView)

        val text2Span: Spannable = SpannableString(text)
        val str = text.split(" ").toTypedArray()
        var startS = 0

        for (i in str.indices) {
            if (str[i].startsWith("http")) {
                if(str[i].endsWith(".") || str[i].endsWith(",") || str[i].endsWith("!") || str[i].endsWith(
                        "?"
                    ) || str[i].endsWith("-")){
                    text2Span.setSpan(
                        ForegroundColorSpan(Color.BLUE),
                        startS,
                        startS + str[i].length-1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }else{
                    text2Span.setSpan(
                        ForegroundColorSpan(Color.BLUE),
                        startS,
                        startS + str[i].length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

            }
            startS += str[i].length + 1
        }
        tv.text = text2Span
    }
}