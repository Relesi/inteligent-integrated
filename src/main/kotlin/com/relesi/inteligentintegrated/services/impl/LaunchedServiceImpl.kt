package com.relesi.inteligentintegrated.services.impl

import com.relesi.inteligentintegrated.documents.Launched
import com.relesi.inteligentintegrated.services.LaunchedService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LaunchedServiceImpl : LaunchedService {

    override fun searchByEmployeeId(employeeId: String, pageRequest: PageRequest): Page<Launched> {
        TODO("Not yet implemented")
    }

    override fun searchById(id: String): Launched? {
        TODO("Not yet implemented")
    }

    override fun persist(lauched: Launched): Launched {
        TODO("Not yet implemented")
    }

    override fun remove(id: String) {
        TODO("Not yet implemented")
    }
}