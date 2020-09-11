package com.jpumpkin.testcode.repository

import com.jpumpkin.testcode.domain.Coffee
import org.springframework.stereotype.Repository

@Repository
class SimpleCoffeeRepository: CoffeeRepository {

    private val coffeeMap = HashMap<String, Coffee>()

    override fun findByName(name: String): Coffee? {
        return coffeeMap[name]
    }

    override fun add(coffee: Coffee) {
        coffeeMap[coffee.name] = coffee
    }
}