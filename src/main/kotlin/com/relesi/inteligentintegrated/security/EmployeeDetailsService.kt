package com.relesi.inteligentintegrated.security

import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.services.EmployeeService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class EmployeeDetailsService(val employeeService: EmployeeService): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            val employee: Employee? = employeeService.searchByEmail(username)
            if (employee != null) {
                return EmployeeMaster(employee)
            }
        }
        throw UsernameNotFoundException(username)
    }

}