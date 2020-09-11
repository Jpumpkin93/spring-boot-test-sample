package com.jpumpkin.testcode.mockBeanTest

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.SimpleCoffeeRepository
import com.jpumpkin.testcode.service.CoffeeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class MockBeanTest {

    @Autowired
    lateinit var coffeeService: CoffeeService

    @MockBean
    lateinit var simpleCoffeeRepository: SimpleCoffeeRepository

    @BeforeEach
    fun setUp(){
        given(this.simpleCoffeeRepository.findByName("americano"))
                .willReturn(Coffee("americano"))
    }

    @Test
    fun `커피 이름으로 조회 잘 되는지`(){
        val coffee = coffeeService.findByName("americano")
        assertEquals("americano", coffee?.name)
    }
}