package com.relesi.inteligentintegrated.documents

import com.relesi.inteligentintegrated.enums.TypeEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document
data class Launched (
    val date: Date,
    val type: TypeEnum,
    val employeesId: String,
    val description: String? = "",
    val localization: String? = "",
    @Id val id: String? = null

)