package com.jpumpkin.testcode.service

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.repository.CoffeeRepository
import org.springframework.stereotype.Service


@Service
class CoffeeService(
        val coffeeRepository: CoffeeRepository
) {

    fun findByName(name: String): Coffee? {
        return coffeeRepository.findByName(name)
    }
}