package com.relesi.inteligentintegrated.dtos

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class LegalPersonRegisterDto (
    @get:NotEmpty(message = "Name cannot be empty...")
    @get:Length(min = 3, max = 200, message = "Name must contain between 3 and 200 characters...")
    val name: String = "",

    @get:NotEmpty(message = "Email cannot be empty....")
    @get:Length(min = 5, max = 200, message = "Email must contain between 5 and 200 characters...")
    @get:Email(message="Invalid email...")
    val email: String = "",

    @get:NotEmpty(message = "Password cannot be empty...")
    val password: String? = null,

    @get:NotEmpty(message = "Ssn cannot be empty...")
    @get:CPF(message = "Invalid")
    val ssn: String = "",

    @get:NotEmpty(message = "Ein cannot be empty...")
    @get:CNPJ(message = "Invalid")
    val ein: String = "", //Employer Identification Number

    @get:NotEmpty(message = "Company name cannot be empty...")
    @get:Length(min = 5, max = 200, message = "Company name must contain between 5 and 200 characters...")
    val businessName: String = "",

    val id: String? = null


)