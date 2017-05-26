package com.josecuentas.android_helloworld_kotlin

/**
 * Created by jcuentas on 26/05/17.
 */

class UserPresenter {

    private val mUserRepository: UserRepository

    init {
        mUserRepository = UserRepository()
        mUserRepository.setUserDataSource {
            it.age
        }

        mUserRepository.add(User("", 12))
    }
}

