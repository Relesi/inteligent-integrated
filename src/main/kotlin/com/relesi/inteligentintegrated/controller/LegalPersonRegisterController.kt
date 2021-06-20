package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.dtos.LegalPersonRegisterDto
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.CompanyService
import com.relesi.inteligentintegrated.services.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/legal-person")
class LegalPersonRegisterController(val companyService: CompanyService,
                                  val employeeService: EmployeeService ){

    fun register(@Valid @RequestBody legalPersonRegisterDto: LegalPersonRegisterDto,
    result: BindingResult): ResponseEntity<Response<LegalPersonRegisterDto>>{
        val response: Response<LegalPersonRegisterDto> = Response<LegalPersonRegisterDto>()
         
    }


}