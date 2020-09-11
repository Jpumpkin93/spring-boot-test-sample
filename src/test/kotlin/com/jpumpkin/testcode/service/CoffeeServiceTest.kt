package com.jpumpkin.testcode.service

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.CoffeeRepository
import com.jpumpkin.testcode.repository.SimpleCoffeeRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.lang.IllegalArgumentException

internal class CoffeeServiceTest{

    private lateinit var coffeeRepository: CoffeeRepository

    private lateinit var coffeeService: CoffeeService


    @BeforeEach
    fun setUp(){
//        coffeeRepository = SimpleCoffeeRepository()
//        coffeeRepository.add(Coffee("americano"))
//        coffeeService = CoffeeService(coffeeRepository)
    }

    @Test
    fun `커피 이름으로 조회가 잘 되는지`(){
        val mockRepo = Mockito.mock(SimpleCoffeeRepository::class.java)
        Mockito.`when`(mockRepo.findByName("americano"))
                .thenReturn(Coffee("americano"))
        val coffeeService = CoffeeService(mockRepo)

        val actualCoffee = coffeeService.findByName("americano") ?: Coffee("mocha")

        assertEquals("americano", actualCoffee.name)
    }

}