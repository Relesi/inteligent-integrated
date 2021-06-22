package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.dtos.LegalPersonRegisterDto
import com.relesi.inteligentintegrated.enums.ProfileEnum
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.CompanyService
import com.relesi.inteligentintegrated.services.EmployeeService
import com.relesi.inteligentintegrated.utils.PasswordUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/legal-person")
class LegalPersonRegisterController(
    val companyService: CompanyService, val employeeService: EmployeeService) {

    @PostMapping
    fun register(
        @Valid @RequestBody legalPersonRegisterDto: LegalPersonRegisterDto,
        result: BindingResult): ResponseEntity<Response<LegalPersonRegisterDto>> {
        val response: Response<LegalPersonRegisterDto> = Response<LegalPersonRegisterDto>()

        validateExistingData(legalPersonRegisterDto, result)

        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val company: Company = converterDtoToCompany(legalPersonRegisterDto)
        companyService.persist(company)

        var employee: Employee = converterDtoToEmplyee(legalPersonRegisterDto, company)
        employee = employeeService.persist(employee)
        response.date = converterLegalPersonRegisterDto(employee, company)

        return ResponseEntity.ok(response)
    }

    private fun validateExistingData(legalPersonRegisterDto: LegalPersonRegisterDto, result: BindingResult) {

        val company: Company? = companyService.searchByEin(legalPersonRegisterDto.ein)
        if (company != null) {
            result.addError(ObjectError("company", "Existing Company..."))
        }

        val employeeSsn: Employee? = employeeService.searchBySsn(legalPersonRegisterDto.ssn)
        if (employeeSsn != null) {
            result.addError(ObjectError("employee", "SSN já existente..."))
        }

        val employeeEmail: Employee? = employeeService.searchByEmail(legalPersonRegisterDto.email)
        if (employeeEmail != null) {
            result.addError(ObjectError("employee", "Existing Email..."))
        }
    }

    private fun converterDtoToCompany(legalPersonRegisterDto: LegalPersonRegisterDto): Company =
        Company(legalPersonRegisterDto.businessName, legalPersonRegisterDto.ein)

    private fun converterDtoToEmplyee(legalPersonRegisterDto: LegalPersonRegisterDto, company: Company) =
        Employee(
            legalPersonRegisterDto.name, legalPersonRegisterDto.email,
            PasswordUtils().generateBCrypt(legalPersonRegisterDto.password), legalPersonRegisterDto.ssn,
            ProfileEnum.ROLE_ADMIN, company.id.toString()
        )

    private fun converterLegalPersonRegisterDto(employee: Employee, company: Company): LegalPersonRegisterDto =
        LegalPersonRegisterDto(
            employee.name, employee.email, "", employee.ssn,
            company.ein, company.businessName, employee.id
        )


}







