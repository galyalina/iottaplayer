package com.chuppa.iotta.tempapp.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Android Scheduler provided used by RxJava.
 */
class AppSchedulerProvider : SchedulerProvider {

    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun backgroundThread(): Scheduler = Schedulers.io()

    override fun someSpecificThread(): Scheduler = specificScheduler

    companion object {
        private val specificScheduler: Scheduler by lazy { Schedulers.single() }
    }
}
