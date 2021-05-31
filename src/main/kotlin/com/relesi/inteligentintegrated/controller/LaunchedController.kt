package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Launched
import com.relesi.inteligentintegrated.dtos.LaunchedDto
import com.relesi.inteligentintegrated.response.Response
import com.relesi.inteligentintegrated.services.EmployeeService
import com.relesi.inteligentintegrated.services.LaunchedService
import org.springframework.beans.factory.annotation.Value

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*

import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/launched")
class LaunchedController(val launchedService: LaunchedService, val employeeService: EmployeeService) {

    private val  dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @Value("\${pagination.qty_by_page}")
    val qtyByPage: Int = 15

    @GetMapping("/employee/{employeeId}")
    fun searchByEmployeeId(@PathVariable("employeeId") employeeId: String,
                            @RequestParam("pag", defaultValue = "0") pag: Int,
                            @RequestParam("ord", defaultValue = "id") ord: String,
                            @RequestParam("dir", defaultValue = "DESC") dir: String):

            ResponseEntity<Response<Page<LaunchedDto>>> {

        val response: Response<Page<LaunchedDto>> = Response<Page<LaunchedDto>>()

        val pageRequest: PageRequest = PageRequest.of(pag, qtyByPage, Sort.Direction.valueOf(dir), ord)

        val launcheds: Page<Launched> = launchedService.searchByEmployeeId(employeeId, pageRequest)

        val launchedsDto: Page<LaunchedDto> = launcheds.map { launched -> converterLaunchedDto(launched) }

        response.date = launchedsDto
        return ResponseEntity.ok(response)

    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable("id") id : String ) : ResponseEntity<Response<LaunchedDto>>{
        val response: Response<LaunchedDto> = Response<LaunchedDto>()
        val launched: Launched? = launchedService.searchById(id)

        if (launched == null){
            response.errors.add("Launched not found for id $id")
            return ResponseEntity.badRequest().body(response)
        }
        response.date = converterLaunchedDto(launched)
        return ResponseEntity.ok(response)
    }

    private fun converterLaunchedDto(launched: Launched): LaunchedDto =
        LaunchedDto(dateFormat.format(launched.date), launched.type.toString(),
            launched.description, launched.localization,
            launched.employeesId, launched.id)

}