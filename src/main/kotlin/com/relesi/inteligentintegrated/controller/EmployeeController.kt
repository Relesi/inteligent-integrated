//package com.relesi.inteligentintegrated.controller
//
//import com.relesi.inteligentintegrated.documents.Company
//import com.relesi.inteligentintegrated.dtos.CompanyDto
//import com.relesi.inteligentintegrated.response.Response
//import com.relesi.inteligentintegrated.services.CompanyService
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//
//@RestController
//@RequestMapping("/api/company")
//class EmployeeController(val companyService: CompanyService) {
//
//    @GetMapping("/ein/{ein}")
//    fun searchToEin(@PathVariable("Ein") ein: String): ResponseEntity<Response<CompanyDto>>{
//        val response: Response<CompanyDto> = Response<CompanyDto>()
//        val company: Company? = companyService.searchByEin(ein)
//
//        if (company == null){
//            response.erros.add("Company not found for EIN ${ein}")
//            return ResponseEntity.badRequest().body(response)
//        }
//
//        response.date = converteCompanyDto(company)
//        return ResponseEntity.ok(response)
//    }
//
//    private fun converteCompanyDto(company: Company): CompanyDto = CompanyDto(company.businessName, company.ein,
//    company.id)
//}