package com.gxy.application

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

class AnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        verticalLayout {
//            backgroundColor = ContextCompat.getColor(applicationContext,R.color.colorPrimary);
//            padding = dip(30)
//            editText {
//                hint = "Name"
//                textSize = 24f
//            }
//            editText {
//                hint = "Password"
//                textSize = 24f
//            }
//            button("Login") {
//                textSize = 26f
//            }
//        }
        MyActivityUI().setContentView(this)
    }
}

class MyActivityUI : AnkoComponent<AnkoActivity> {
    override fun createView(ui: AnkoContext<AnkoActivity>) = ui.apply {
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }.view
}