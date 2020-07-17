package com.chuppa.iotta.tempapp.ui

import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import com.chuppa.iotta.tempapp.data.network.model.User
import com.chuppa.iotta.tempapp.domain.Repository
import androidx.lifecycle.toLiveData

class UsersViewModel(private val repository: Repository) : ViewModel() {

    val users: LiveData<List<User>>
        get() = repository.getList(1)
            .onErrorReturn { emptyList() }
            .toFlowable().toLiveData()


}