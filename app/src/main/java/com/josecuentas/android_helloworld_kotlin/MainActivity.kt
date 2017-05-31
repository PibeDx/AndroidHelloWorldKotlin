package com.josecuentas.android_helloworld_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserPresenter.View {

    lateinit var userPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectPresenter()
        events()
    }

    private fun injectPresenter() {
        val userRepository = UserRepository()
        userRepository.setUserDataSource { println("Age: ${it.age}") }

        //Other Alt
        /*userRepository.setUserDataSource(object : UserDataSource{
            override fun add(user: User) { println("age: ${user.age}") }
        })
        userRepository.setUserDataSource { println("age: ${it.age}") }
        userRepository.setUserDataSource { user: User -> println(user.age) }
        userRepository.setUserDataSource { user -> println(user.age) }*/

        userPresenter = UserPresenter(userRepository)
        userPresenter.setView(this)
    }

    private fun events() {
        butIngresar.setOnClickListener {
            //hello()
            userPresenter.addUser(User("José", 23))
        }
    }

    private fun hello() {
        var name = eteName.text
        var cadena = getString(R.string.main_hi, name)
        val fromHtml: Spanned = Html.fromHtml(cadena)
        tviMessage.text = fromHtml
    }

    override fun success() {
        tviMessage.text = "Se agrego su nombre correctamente"
    }

    override fun error() {
        tviMessage.text = "Ocurrio un error al agregar su nombre"
    }
}
