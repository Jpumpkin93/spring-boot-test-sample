package com.jpumpkin.testcode.integrationTest

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.CoffeeRepository
import com.jpumpkin.testcode.repository.SimpleCoffeeRepository
import com.jpumpkin.testcode.service.CoffeeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class IntegrationTest(

) {
    @Autowired
    lateinit var coffeeRepository: CoffeeRepository
    @Autowired
    lateinit var coffeeService: CoffeeService

    @Test
    fun `커피이름으로 조회 잘 되는지`(){
        val coffee = Coffee("americano")
        coffeeRepository.add(coffee)

        val actualCoffee = coffeeService.findByName("americano")
        assertEquals("americano", actualCoffee?.name)
    }
}