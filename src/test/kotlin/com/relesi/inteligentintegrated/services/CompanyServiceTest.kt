package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Company
import com.relesi.inteligentintegrated.repositories.CompanyRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import kotlin.jvm.Throws


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureDataMongo
class CompanyServiceTest {

    @Autowired
    val companyService: CompanyService? = null

    @MockBean
    private val companyRepository: CompanyRepository? = null

    private val EIN = "26579219000180"

    private fun company(): Company = Company("Employer Identification Number", EIN, "1")

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(companyRepository?.findByEin(EIN)).willReturn(company())
        BDDMockito.given(companyRepository?.save(company())).willReturn(company())
    }

    @Test
    fun testSearchCompanyByEin(){
        val company: Company? = companyService?.searchByEin(EIN)
        Assertions.assertNotNull(company)
    }

    @Test
    fun testPersistCompany(){
        val company: Company? = companyService?.persist(company())
    }


}

