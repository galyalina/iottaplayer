package com.chuppa.iotta.tempapp.dependency

import com.chuppa.iotta.tempapp.data.network.RepositoryImpl
import com.chuppa.iotta.tempapp.domain.Repository
import org.koin.dsl.module

val dataModule =  dataNetworkModule + module {

    single<Repository> {
        RepositoryImpl(
            networkClient = get()
        )
    }
}
