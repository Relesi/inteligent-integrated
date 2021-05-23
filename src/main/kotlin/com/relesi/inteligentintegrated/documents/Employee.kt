package com.relesi.inteligentintegrated.documents

import com.relesi.inteligentintegrated.enums.ProfileEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Employee (
    val name: String,
    val email: String,
    val password: String,
    val ssn: String, //Social Security Number
    val profile: ProfileEnum,
    val companyId: String,
    val hourValue: Double? = 0.0,
    val qtyHoursWorkedDay: Float? = 0.0f,
    val qtyLunchHours: Float? = 0.0f,
    @Id val id: String? = null

)