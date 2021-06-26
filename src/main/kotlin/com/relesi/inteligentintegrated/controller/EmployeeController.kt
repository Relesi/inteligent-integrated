package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.dtos.CompanyDto
import com.relesi.inteligentintegrated.dtos.EmployeeDto
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.CompanyService
import com.relesi.inteligentintegrated.services.EmployeeService
import com.relesi.inteligentintegrated.utils.PasswordUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/employee")
class EmployeeController(val employeeService: EmployeeService) {

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @Valid @RequestBody employeeDto: EmployeeDto,
    result: BindingResult): ResponseEntity<Response<EmployeeDto>>{

        val response: Response<EmployeeDto> = Response<EmployeeDto>()
        val employee: Employee? = employeeService.searchById(id)

        if (employee == null){
            result.addError(ObjectError("employee", "Employee not found."))
        }

        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val funUpdate: Employee = updateEmployeeData(employee!!, employeeDto)
        employeeService.persist(funUpdate)
        response.date = converteEmployeeDto(funUpdate)

        return ResponseEntity.ok(response)

    }

    private fun updateEmployeeData(employee: Employee, employeeDto: EmployeeDto): Employee {

        var password: String
        if (employeeDto.password == null) {
            password = employee.password
        } else {
            password = PasswordUtils().generateBCrypt(employeeDto.password)
        }

        return Employee(
            employeeDto.name, employee.email, password,
            employee.ssn, employee.profile, employee.companyId,
            employeeDto.hourValue?.toDouble(),
            employeeDto.qtyHoursWorkedDay?.toFloat(),
            employeeDto.qtyLunchHours?.toFloat(), employee.id
        )
    }

    private fun converteEmployeeDto(emnployee: Employee): EmployeeDto = EmployeeDto(
        emnployee.name, emnployee.email, "",
        emnployee.hourValue.toString(), emnployee.qtyHoursWorkedDay.toString(),
        emnployee.qtyLunchHours.toString(), emnployee.id
    )

}