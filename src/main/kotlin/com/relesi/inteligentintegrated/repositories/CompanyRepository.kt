package com.relesi.inteligentintegrated.repositories

import com.relesi.inteligentintegrated.documents.Company
import org.springframework.data.mongodb.repository.MongoRepository

interface CompanyRepository : MongoRepository<Company, String> {

    fun findByEin(ein: String): Company?
}