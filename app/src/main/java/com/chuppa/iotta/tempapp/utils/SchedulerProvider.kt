package com.chuppa.iotta.tempapp.utils

import io.reactivex.rxjava3.core.Scheduler


/**
 * Scheduler Provider interface for dagger.
 */
interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler

    fun someSpecificThread(): Scheduler
}
