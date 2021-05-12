package com.relesi.inteligentintegrated.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Company (
    val businessName: String,
    val ein: String, //Employer Identification Number
    @Id val id: String? = null
)