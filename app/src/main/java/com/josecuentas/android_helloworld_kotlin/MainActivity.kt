package com.josecuentas.android_helloworld_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        events()
    }

    private fun events() {
        butIngresar.setOnClickListener {
            var name = eteName.text
            var cadena = getString(R.string.main_hi, name)
            val fromHtml: Spanned = Html.fromHtml(cadena)
            tviMessage.text = fromHtml
        }
    }

}
