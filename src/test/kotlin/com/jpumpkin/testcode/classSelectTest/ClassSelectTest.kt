package com.jpumpkin.testcode.classSelectTest

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.SimpleCoffeeRepository
import com.jpumpkin.testcode.service.CoffeeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(
        classes = [CoffeeService::class, SimpleCoffeeRepository::class]
)
internal class ClassSelectTest {


    @Autowired
    private lateinit var coffeeService: CoffeeService
    @Autowired
    private lateinit var simpleCoffeeRepository: SimpleCoffeeRepository

    @Test
    fun `커피 이름으로 조회 잘 되는지`() {
        simpleCoffeeRepository.add(Coffee("americano"))
        val coffee = coffeeService.findByName("americano")
        assertEquals("americano", coffee?.name)
    }
}