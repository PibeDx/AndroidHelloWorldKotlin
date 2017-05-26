package com.josecuentas.android_helloworld_kotlin

/**
 * Created by jcuentas on 26/05/17.
 */

class UserRepository {
    private var mUserDataSource: UserDataSource? = null

    fun setUserDataSource(userDataSource: UserDataSource) {
        mUserDataSource = userDataSource
    }
    fun add(user: User) {
        mUserDataSource!!.add(user)
    }

}
fun UserRepository.setUserDataSource(userDataSource: (User) -> Unit) {}




