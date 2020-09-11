package com.jpumpkin.testcode.repository

import com.jpumpkin.testcode.domain.Coffee
import org.springframework.stereotype.Repository


interface CoffeeRepository {

    fun findByName(name: String): Coffee?
    fun add(coffee: Coffee)
}