package com.chuppa.iotta.tempapp.data.network

import com.chuppa.iotta.tempapp.data.network.model.User
import com.chuppa.iotta.tempapp.domain.Repository
import io.reactivex.Single

class RepositoryImpl(private val networkClient: UserRemoteSource) : Repository {
    override fun getList(page: Int): Single<List<User>> {
        return networkClient.fetchUsers()
            .toObservable()
            .flatMapIterable { items ->
                items
            }
            .flatMapSingle { item ->
                networkClient.fetchUser(item.login)
                    .map { item.copy(imageUrl = it.avatar_url) }
                    .onErrorReturn { item }
            }
            .toList()
    }

}