package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.dtos.LaunchedDto
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.EmployeeService
import com.relesi.inteligentintegrated.services.LaunchedService

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat


@RestController
@RequestMapping("/api/launched")
class LaunchedController(val launchedService: LaunchedService, val employeeService: EmployeeService) {

    private val  dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val qtyByPage: Int = 15

    fun searchByEmployeeId(@PathVariable("employeeId") employeeId: String,
                            @RequestParam("pag", defaultValue = "0") pag: Int,
                            @RequestParam("ord", defaultValue = "id") ord: String,
                            @RequestParam("dir", defaultValue = "DESC") dir: String):

            ResponseEntity<Response<Page<LaunchedDto>>> {

        val response: ResponseEntity<Response<Page<LaunchedDto>> = Response<Page<LaunchedDto>>()

        val pageRequest: PageRequest = PageRequest.of(pag, qtyByPage, Sort.Direction.valueOf(dir), ord)
        val launchedDto: Page<LaunchedDto> =
            launchedService.searchByEmployeeId(employeeId, pageRequest)

        val launchedDto: Page<LaunchedDto> =
            launcheds.map { launched -> converterLancamentoDto(launched) }

        response.data = lancamentosDto
        return ResponseEntity.ok(response)

    }

    //still developing




}