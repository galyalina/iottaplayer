package com.chuppa.iotta.tempapp.ui

import com.chuppa.iotta.tempapp.dependency.dataModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListFragmentModule = dataModule + module {
    viewModel {
        UsersViewModel(
            repository = get()
        )
    }
}