package com.jpumpkin.testcode.repository

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.domain.EntityCoffee
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.lang.IllegalArgumentException


//생성자 DI
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@DataJpaTest
internal class CoffeeJpaRepositoryTest(
        val coffeeJpaRepository: CoffeeJpaRepository
){

    @Test
    fun test(){
        coffeeJpaRepository.save(EntityCoffee(id = 1L, name = "americano"))
        val coffee = coffeeJpaRepository.findById(1L)
        then(coffee.get().name).isEqualTo("americano")
        assertEquals("americano", coffee.get().name)


    }


}