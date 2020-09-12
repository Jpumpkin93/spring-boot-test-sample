package com.jpumpkin.testcode.webEnvironmentTest

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.CoffeeRepository
import com.jpumpkin.testcode.service.CoffeeService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class WebEnvironmentTest {

    @Autowired
    lateinit var coffeeRepository: CoffeeRepository
    @Autowired
    lateinit var coffeeService: CoffeeService

    @Test
    fun `커피이름으로 조회 잘 되는지`(){
        val coffee = Coffee("americano")
        coffeeRepository.add(coffee)

        val actualCoffee = coffeeService.findByName("americano")
        Assertions.assertEquals("americano", actualCoffee?.name)
    }
}