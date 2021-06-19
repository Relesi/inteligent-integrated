package com.relesi.inteligentintegrated.controller

import com.relesi.inteligentintegrated.documents.Employee
import com.relesi.inteligentintegrated.documents.Launched
import com.relesi.inteligentintegrated.dtos.LaunchedDto
import com.relesi.inteligentintegrated.enums.ProfileEnum
import com.relesi.inteligentintegrated.enums.TypeEnum
import com.relesi.inteligentintegrated.services.EmployeeService
import com.relesi.inteligentintegrated.services.LaunchedService
import com.relesi.inteligentintegrated.utils.PasswordUtils
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureDataMongo
class LaunchedControllerTest {

    @Autowired
    private val mvc: MockMvc? = null

    @MockBean
    private val launchedService: LaunchedService? = null

    @MockBean
    private val employeeService: EmployeeService? = null

    private val urlBase: String = "/api/launcheds"/**/
    private val idEmployee: String = "1"
    private val idLaunched: String = "1"
    private val type: String = TypeEnum.START_WORK.name
    private val date: Date = Date()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @Test
    @WithMockUser
    @Throws(Exception::class)
    fun testPersistLaunched() {
        val launched: Launched = getDataLaunched()

        BDDMockito.given<Employee>(employeeService?.searchById(idEmployee)).willReturn(employee())
        BDDMockito.given(launchedService?.persist(getDataLaunched())).willReturn(launched)

        mvc!!.perform(
            MockMvcRequestBuilders.post(urlBase)
                .content(getJsonRequestPost())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.date.type").value(type))
            .andExpect(jsonPath("$.date.date").value(dateFormat.format(date)))
            //.andExpect(jsonPath("$.date.employeeId").value(idEmployee))
            .andExpect(jsonPath("$.erros").isEmpty())
    }

    @Test
    @WithMockUser
    @Throws(Exception::class)
    fun testPersistLaunchedEmployeeInvalid() {

        BDDMockito.given<Employee>(employeeService?.searchById(idEmployee)).willReturn(null)

        mvc!!.perform(
            MockMvcRequestBuilders.post(urlBase)
                .content(getJsonRequestPost())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.erros").value("Employee not found. non-existent ID."))
            .andExpect(jsonPath("$.date").isEmpty())
    }

    @Test
    @WithMockUser(username = "admin@admin.com", roles = arrayOf("ADMIN"))
    @Throws(Exception::class)
    fun testRemoveLaunched() {

        BDDMockito.given<Launched>(launchedService?.searchById(idLaunched)).willReturn(getDataLaunched())

        mvc!!.perform(MockMvcRequestBuilders.delete(urlBase + idLaunched)
            .accept(MediaType.APPLICATION_JSON))
        //TODO
            //.andExpect(status().isOk())

    }


    @Throws(JsonProcessingException::class)
    private fun getJsonRequestPost(): String {
        val launchedDto: LaunchedDto = LaunchedDto(
            dateFormat.format(date),
            type,
            "Description",
            "1.234,4.234",
            idEmployee
        )
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(launchedDto)
    }

    private fun getDataLaunched(): Launched = Launched(
        date, TypeEnum.valueOf(type),
        idEmployee, "description", "1.243,4.345", idLaunched
    )

    private fun employee(): Employee =
        Employee(
            "Name", "email@email.com", PasswordUtils().generateBCrypt("123456"),
            "11375729063", ProfileEnum.ROLE_USER, idEmployee
        )

}