package com.josecuentas.android_helloworld_kotlin

/**
 * Created by jcuentas on 26/05/17.
 */

class UserRepository {

    var mUserDataSource: UserDataSource? = null

    fun setUserDataSource(userDataSource: (UserDataSource)) {
        mUserDataSource = userDataSource
    }

    fun setUserDataSource(listener: (user: User) -> Unit) {
        mUserDataSource = object : UserDataSource {
            override fun add(user: User) { listener(user) }
        }
    }

    fun add(user: User) {
        mUserDataSource?.add(user) ?: println("mUserDataSource is null")
    }

}