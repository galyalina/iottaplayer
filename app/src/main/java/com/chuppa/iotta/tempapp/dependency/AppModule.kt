package com.chuppa.iotta.tempapp.dependency

import com.chuppa.iotta.tempapp.utils.AppSchedulerProvider
import com.chuppa.iotta.tempapp.utils.SchedulerProvider
import org.koin.dsl.module

val appModule = module {

    single { AppSchedulerProvider() as SchedulerProvider }
}
