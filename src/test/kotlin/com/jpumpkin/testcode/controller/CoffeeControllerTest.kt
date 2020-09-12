package com.jpumpkin.testcode.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CoffeeController::class)
internal class CoffeeControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @DisplayName("Get helloCoffee call이 잘 되는지")
    fun helloCoffee() {
        mockMvc.get("/admin") {
            accept(MediaType.APPLICATION_JSON)
        }.andExpect {
                    status().isOk
                    content().string("helloCoffee")
        }

    }
}