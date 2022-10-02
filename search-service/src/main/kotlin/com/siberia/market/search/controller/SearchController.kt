package com.siberia.market.search.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/search")
class SearchController(

) {
    @GetMapping("")
    fun findAllProducts(): String {
        return "search test"
    }

}