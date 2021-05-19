package com.relesi.inteligentintegrated.services.impl

import com.relesi.inteligentintegrated.documents.Employees
import com.relesi.inteligentintegrated.services.EmployeesService

class EmployeeServiceImpl : EmployeesService {

    override fun persist(employees: Employees): Employees {
        TODO("Not yet implemented")
    }

    override fun searchBySsn(ssn: String): Employees? {
        TODO("Not yet implemented")
    }

    override fun searchByEmail(email: String): Employees? {
        TODO("Not yet implemented")
    }

    override fun searchById(id: String): Employees? {
        TODO("Not yet implemented")
    }
}