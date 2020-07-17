package com.chuppa.iotta.tempapp.data.network.model

data class Result (val total_count: Int, val incomplete_results: Boolean, val items: List<User>)