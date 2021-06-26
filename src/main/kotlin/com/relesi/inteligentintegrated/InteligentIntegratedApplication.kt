package com.relesi.inteligentintegrated

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.enums.ProfileEnum
import com.relesi.inteligentintegrated.repositories.CompanyRepository
import com.relesi.inteligentintegrated.repositories.EmployeeRepository
import com.relesi.inteligentintegrated.repositories.LaunchedRepository
import com.relesi.inteligentintegrated.utils.PasswordUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

//@SpringBootApplication
////@SpringBootApplication(exclude = arrayOf(SecurityAutoConfiguration::class))
//class InteligentIntegratedApplication(val companyRepository: CompanyRepository,
//									  val employeeRepository: EmployeeRepository,
//									  val launchedRepository: LaunchedRepository) : CommandLineRunner{
//
//	override fun run (vararg args: String?){
//		companyRepository.deleteAll()
//		employeeRepository.deleteAll()
//		launchedRepository.deleteAll()
//
//		var company: Company = Company("Company", "61486174000109")
//		//companyRepository.save(company)
//		company = companyRepository.save(company)
//
//		var admin: Employee = Employee("Admin", "admin@company.com",
//		PasswordUtils().generateBCrypt("123456"), "34732052061",
//			ProfileEnum.ROLE_ADMIN, company.id!!)
//		//employeeRepository.save(admin)
//		admin = employeeRepository.save(admin)
//
//		var employee: Employee = Employee("Employee",
//		"employee@company.com", PasswordUtils().generateBCrypt("123456"),
//			"92536359085", ProfileEnum.ROLE_USER, company.id!!)
//		//employeeRepository.save(employee)
//		employee = employeeRepository.save(employee)
//
//		System.out.println("Company ID: " + company.id)
//		System.out.println("Admin ID: " + admin.id)
//		System.out.println("Employee ID: " + employee.id)
//	}
//}


//
//fun main(args: Array<String>) {
//	SpringApplication.run(InteligentIntegratedApplication::class.java, *args)

@SpringBootApplication
class InteligentIntegratedApplication

fun main(args: Array<String>) {
    runApplication<InteligentIntegratedApplication>(*args)
}