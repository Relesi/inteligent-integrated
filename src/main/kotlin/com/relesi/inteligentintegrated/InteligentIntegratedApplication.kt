package com.relesi.inteligentintegrated

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.enums.ProfileEnum
import com.relesi.inteligentintegrated.repositories.CompanyRepository
import com.relesi.inteligentintegrated.repositories.EmployeeRepository
import com.relesi.inteligentintegrated.utils.PasswordUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InteligentIntegratedApplication(val companyRepository: CompanyRepository,
val employeeRepository: EmployeeRepository): CommandLineRunner{
	fun run (vararg args: String?){
		companyRepository.deleteAll()
		employeeRepository.deleteAll()

		val company: Company = Company("Company", "61486174000109")
		companyRepository.save(company)

		val admin: Employee = Employee("Admin", "admin@company.com",
		PasswordUtils().generateBCrypt("123456"), "34732052061",
			ProfileEnum.ROLE_ADMIN, company.id!!)
		employeeRepository.save(admin)

		val employee: Employee = Employee("Employee",
		"employee@company.com", PasswordUtils().generateBCrypt("123456"),
			"92536359085", ProfileEnum.ROLE_USER, company.id!!)
		employeeRepository.save(employee)

		System.out.println("Company ID: " + company.id)
		System.out.println("Admin ID: " + admin.id)
		System.out.println("Employee ID: " + employee.id)
	}
}



//fun main(args: Array<String>) {
//	runApplication<InteligentIntegratedApplication>(*args)
//}
