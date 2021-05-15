package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Company

interface CompanyService {

    fun searchByEin(ein: String): Company?

    fun persist(company: Company): Company
}