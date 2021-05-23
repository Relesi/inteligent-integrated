package com.relesi.inteligentintegrated.services.impl

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.repositories.CompanyRepository
import com.relesi.inteligentintegrated.services.CompanyService
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(val companyRepository: CompanyRepository): CompanyService {

    override
    fun searchByEin(ein: String): Company? = companyRepository.findByEin(ein)

    override
    fun persist(company: Company): Company = companyRepository.save(company)


}