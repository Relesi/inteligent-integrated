package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Employee

interface EmployeeService {

    fun persist(employee: Employee): Employee

    fun searchBySsn(ssn: String): Employee?

    fun searchByEmail(email: String): Employee?

    fun searchById(id: String): Employee?


}