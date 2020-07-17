package com.chuppa.iotta.tempapp.dependency

import com.chuppa.iotta.tempapp.data.network.UserRemoteSource
import com.google.gson.Gson
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.UnknownHostException

val dataNetworkModule = module {

    single {
        val baseUrl: String = "https://api.github.com/"
        baseUrl.toHttpUrlOrNull() ?: throw UnknownHostException("Invalid host: $baseUrl")
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder().apply {
            val interceptor: HttpLoggingInterceptor = get()
            addInterceptor(interceptor)

        }.build()
    }

    single<Retrofit> {
        val baseUrl: HttpUrl = get()
        val okHttpClient: OkHttpClient = get()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation()))
            .build()
    }

    single<UserRemoteSource> {
        val retrofit: Retrofit = get()
        retrofit.create(UserRemoteSource::class.java)
    }
}

