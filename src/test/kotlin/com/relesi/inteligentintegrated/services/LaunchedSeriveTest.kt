package com.relesi.inteligentintegrated.services

import com.relesi.inteligentintegrated.documents.Launched
import com.relesi.inteligentintegrated.enums.TypeEnum
import com.relesi.inteligentintegrated.repositories.LaunchedRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

import org.springframework.data.domain.PageRequest
import org.springframework.test.context.ActiveProfiles
import java.util.*


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureDataMongo
class LaunchedSeriveTest {

    @MockBean
    private val launchedRepository: LaunchedRepository? = null

    @Autowired
    private val launchedService: LaunchedService? = null

    private val id: String = "1";

    private fun launched(): Launched = Launched(Date(), TypeEnum.START_WORK, id)

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given<Page<Launched>>(launchedRepository?.findByEmployeesId(id, PageRequest.of(0,10)))
            .willReturn(PageImpl(ArrayList<Launched>()))
        BDDMockito.given(launchedRepository?.findById("1")).willReturn(Optional.of(launched()))
        BDDMockito.given(launchedRepository?.save(Mockito.any(Launched::class.java))).willReturn(launched())
    }

    @Test
    fun testSearchLaunchedByEmployee(){
        val launched: Page<Launched>? = launchedService?. searchByEmployeeId(id, PageRequest.of(0, 10))
        Assertions.assertNotNull(launched)
    }

    @Test
    fun testSearchLaunchedBYId(){
        val launched: Launched? = launchedService?.searchById(id)
        Assertions.assertNotNull(launched)
    }

    @Test
    fun testPersistLaunched(){
        val launched: Launched? = launchedService?.persist(launched())
        Assertions.assertNotNull(launched)
    }
}