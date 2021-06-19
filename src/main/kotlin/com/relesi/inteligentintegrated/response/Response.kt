package com.relesi.inteligentintegrated.response

data class Response<T>(
    val erros: ArrayList<String> = arrayListOf(),
    var date: T? = null
)