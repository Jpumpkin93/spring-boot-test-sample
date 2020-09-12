package com.jpumpkin.testcode.repository

import com.jpumpkin.testcode.domain.Coffee
import com.jpumpkin.testcode.domain.EntityCoffee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface CoffeeJpaRepository: JpaRepository<EntityCoffee, Long> {
}