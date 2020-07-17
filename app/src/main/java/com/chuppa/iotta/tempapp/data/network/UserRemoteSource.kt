package com.chuppa.iotta.tempapp.data.network

import com.chuppa.iotta.tempapp.data.network.model.DetailedUser
import com.chuppa.iotta.tempapp.data.network.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRemoteSource {

    @GET(value = "/users")
    fun fetchUsers(): Single<List<User>>


    @GET(value = "/users/{id}")
    fun fetchUser(@Path("id") id: String): Single<DetailedUser>

}
