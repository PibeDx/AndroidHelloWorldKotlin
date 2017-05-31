package com.josecuentas.android_helloworld_kotlin

/**
 * Created by jcuentas on 26/05/17.
 */

class UserPresenter/*(var userRepository: UserRepository)*/ {

    private var userRepository: UserRepository

    private var view: View? = null

    constructor(userRepository: UserRepository){
        this.userRepository = userRepository
    }

    fun setView(view:View) {
        this.view = view
    }

    /*init {
        userRepository = UserRepository()
        //mUserRepository.setUserDataSource(object : UserDataSource{
        //    override fun add(user: User) { println("age: ${user.age}") }
        //})

        userRepository.setUserDataSource { println("age: ${it.age}") }
        //mUserRepository.setUserDataSource { user: User -> println(user.age) }
        //mUserRepository.setUserDataSource { user -> println(user.age) }

    }*/

    fun addUser(user:User){
        userRepository.add(user)
        this.view?.success()
    }

    interface View {

        fun success()

        fun error()

    }
}