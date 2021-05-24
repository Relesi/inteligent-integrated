package com.relesi.inteligentintegrated.dtos

import com.relesi.inteligentintegrated.enums.ProfileEnum
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class EmployeeDto(

    @get:
    NotEmpty(message = "Name cannot be empty...")
    @get:Length(min = 3, max = 200, message = "Name must contain between 3 and 200 characters...")
    val name: String = "",

    @get:NotEmpty(message = "Email cannot be empty....")
    @get:Length(min = 5, max = 200, message = "Email must contain between 5 and 200 characters...")
    @get:Email(message="Invalid email...")
    val email: String = "",

    val password: String? = null,
    val hourValue: String? = null,
    val qtyHoursWorkedDay: String? ? = null,
    val qtyLunchHours: String? = null,
    val id: String? = null

)
