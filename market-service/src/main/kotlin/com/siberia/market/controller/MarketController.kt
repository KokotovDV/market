package com.siberia.market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/market")
class MarketController(
) {
    @GetMapping("")
    fun findProductByTitle(@RequestParam title: String): Boolean {
        return true
    }

}