package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Company
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

        val company: Company? = 


    }
}