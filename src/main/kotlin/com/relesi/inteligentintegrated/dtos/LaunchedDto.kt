package com.relesi.inteligentintegrated.dtos

import javax.validation.constraints.NotEmpty

class LaunchedDto (
    @get:NotEmpty(message = "Date cannot be empty...")
    val date: String? = null,

    @get:NotEmpty(message = "Type cannot be empty...")
    val type: String? = null,

    val employeesId: String? = null,
    val description: String? = null,
    val localization: String? = null,
    var id: String? = null
)

