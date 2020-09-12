package com.jpumpkin.testcode.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/coffee")
class CoffeeController {

    @GetMapping
    fun helloCoffee(): String {
        return "helloCoffee"
    }
}