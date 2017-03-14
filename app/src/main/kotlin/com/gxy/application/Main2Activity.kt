package com.gxy.application

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
        MyActivityUI().setContentView(this)
    }
}

class MyActivityUI : AnkoComponent<Main2Activity> {
    override fun createView(ui: AnkoContext<Main2Activity>) = ui.apply {
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }.view
}