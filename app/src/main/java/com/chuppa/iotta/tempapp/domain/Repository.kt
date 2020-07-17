package com.chuppa.iotta.tempapp.domain

import com.chuppa.iotta.tempapp.data.network.model.User
import io.reactivex.Single

interface Repository {

    fun getList(page: Int): Single<List<User>>

}
