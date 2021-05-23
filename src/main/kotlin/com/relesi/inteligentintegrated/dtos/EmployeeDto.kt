package com.relesi.inteligentintegrated.dtos

import com.relesi.inteligentintegrated.enums.ProfileEnum
import javax.validation.constraints.NotEmpty


data class EmployeeDto(

    @get:
    NotEmpty(message = "Name cannot be empty...")
    val name: String = "",
    val email: String,
    val password: String,

    val profile: ProfileEnum,
    val companyId: String,
    val hourValue: Double? = 0.0,
    val qtyHoursWorkedDay: Float? = 0.0f,
    val qtyLunchHours: Float? = 0.0f,



    val id: String? = null

)
