package com.relesi.inteligentintegrated.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordUtilsTest {

    private val SENHA = "123456"
    private val bCryptEncoder = BCryptPasswordEncoder()

    @Test
    fun testGenerateHashPassword(){
        val hash = PasswordUtils().generateBCrypt(SENHA)
        Assertions.assertTrue(bCryptEncoder.matches(SENHA, hash))
    }
}