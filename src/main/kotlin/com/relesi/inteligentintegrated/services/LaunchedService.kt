package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Launched
import org.springframework.data.domain.AbstractPageRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface LaunchedService {

    fun searchByEmployeeId(employeeId: String, pageRequest: PageRequest): Page<Launched>
    fun searchById(id: String): Launched?
    fun persist(lauched: Launched): Launched
    fun remove(id: String)
}