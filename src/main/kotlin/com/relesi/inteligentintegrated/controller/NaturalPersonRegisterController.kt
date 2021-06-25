package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.dtos.NaturalPersonRegisterDto
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.CompanyService
import com.relesi.inteligentintegrated.services.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/natural-person")
class NaturalPersonRegisterController(val companyService: CompanyService, val employeeService: EmployeeService) {

    @PostMapping
    fun register(@Valid  @RequestBody naturalPersonRegisterDto: NaturalPersonRegisterDto,
                 result: BindingResult): ResponseEntity<Response<NaturalPersonRegisterDto>> {
        val response: Response<NaturalPersonRegisterDto> = Response<NaturalPersonRegisterDto>()

        val company: Company? = companyService.searchByEin(naturalPersonRegisterDto.ein)
        validateExistingData(naturalPersonRegisterDto, company, result)

        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        //var employee: Employee = converterDtoToEmplyee(naturalPersonRegisterDto, company!!)
       // employee = employeeService.persist(employee)
        //response.date = converterNaturalPersonRegisterDto(employee, company!!)

        return ResponseEntity.ok(response)



    }

//    private fun converterNaturalPersonRegisterDto(employee: Employee, company: Company): NaturalPersonRegisterDto? {
//
//    }
//
//    private fun converterDtoToEmplyee(naturalPersonRegisterDto: NaturalPersonRegisterDto, company: Company): Employee {
//
//    }

    private fun validateExistingData(naturalPersonRegisterDto: NaturalPersonRegisterDto, company: Company?, result: BindingResult) {

    }
}