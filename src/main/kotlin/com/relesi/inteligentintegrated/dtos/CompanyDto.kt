package com.relesi.inteligentintegrated.dtos

data class CompanyDto (
    val businessName: String,
    val ein: String, //Employer Identification Number
    val id: String? = null

)