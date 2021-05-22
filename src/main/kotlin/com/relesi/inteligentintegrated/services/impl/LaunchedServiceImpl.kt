package com.relesi.inteligentintegrated.services.impl

import com.relesi.inteligentintegrated.documents.Launched
import com.relesi.inteligentintegrated.repositories.LaunchedRepository
import com.relesi.inteligentintegrated.services.LaunchedService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LaunchedServiceImpl (val launchedRepository: LaunchedRepository) : LaunchedService {

    override
    fun searchByEmployeeId(employeeId: String, pageRequest: PageRequest) =
            launchedRepository.findByEmployeesId(employeeId, pageRequest)

    override
    fun searchById(id: String): Launched? = launchedRepository.findById(id).get()

    override
    fun persist(launched: Launched) = launchedRepository.save(launched)

    override
    fun remove(id: String) = launchedRepository.deleteById(id)
}