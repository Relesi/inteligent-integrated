package com.relesi.inteligentintegrated.repositories

import com.relesi.inteligentintegrated.documents.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {

    fun findByEmail(email: String): Employee?
    fun findBySsn(ssn: String): Employee?
}