package com.relesi.inteligentintegrated.repositories

import com.relesi.inteligentintegrated.documents.Employees
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employees, String> {

    fun findByEmail(email: String): Employees?

    fun findBySsn(ssn: String): Employees?
}