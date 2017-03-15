package com.gxy.application

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import org.jetbrains.anko.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            backgroundColor = 100123100
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                id = R.id.text2
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
            }
        }
//        setContentView(R.layout.activity_main22)
        main1(null)
    }

    fun main1(tt: String?) {
        var javaArray = ArrayList<Int>()
        javaArray.add(1)
        javaArray.add(2)
        javaArray.add(3)
        var kotlinList = listOf("k", "o", "t")
        for (a in javaArray) {
            Log.d("javaArray", a.toString())
        }
        for (a in kotlinList) {
            Log.d("kotlinList", a)
        }

        var text2 = find<TextView>(R.id.text2)
        text2.text = tt
    }
}
