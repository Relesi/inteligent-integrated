package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.enums.ProfileEnum
import com.relesi.inteligentintegrated.repositories.EmployeeRepository
import com.relesi.inteligentintegrated.utils.PasswordUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*


@SpringBootTest
@AutoConfigureDataMongo
class EmployeesSeriveTest {

    @MockBean
    private val employeeRepository: EmployeeRepository? = null

    @Autowired
    private val employeeService: EmployeeService? = null

    private val email: String = "email@email.com"
    private val ssn: String = "43126751040"
    private val id: String = "1"

    fun setUp(){
        BDDMockito.given(employeeRepository?.save(Mockito.any(Employee::class.java))).willReturn(employee())
        BDDMockito.given(employeeRepository?.findById(id)).willReturn(Optional.of(employee()))
        BDDMockito.given(employeeRepository?.findByEmail(email)).willReturn(employee())
        BDDMockito.given(employeeRepository?.findBySsn(ssn)).willReturn(employee())
    }

    @Test
    fun testPersistEmployee(){
        val  employe: Employee? = this.employeeService?.persist(employee())
        Assertions.assertNotNull(employe)
    }

    private fun employee(): Employee =
        Employee("Name", email, PasswordUtils().generateBCrypt("123456"),
            ssn, ProfileEnum.ROLE_USER, id)


}