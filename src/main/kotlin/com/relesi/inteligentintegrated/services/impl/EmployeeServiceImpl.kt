package com.relesi.inteligentintegrated.services.impl

import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.repositories.EmployeeRepository
import com.relesi.inteligentintegrated.services.EmployeeService
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl (val employeeRepository: EmployeeRepository): EmployeeService {

    override fun persist(employee: Employee): Employee = employeeRepository.save(employee)

    override fun searchBySsn(ssn: String): Employee? = employeeRepository.findBySsn(ssn)

    override fun searchByEmail(email: String): Employee? = employeeRepository.findByEmail(email)

    override fun searchById(id: String): Employee? = employeeRepository.findById(id).get()


}