package com.relesi.inteligentintegrated.response

data class Response<T> (
    val errors: ArrayList<String> = arrayListOf(),
    var date: T? = null
)