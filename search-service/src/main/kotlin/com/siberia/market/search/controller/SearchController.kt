package com.siberia.market.search.controller

import com.siberia.market.search.domain.Product
import com.siberia.market.search.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/v1/search")
class SearchController(
    private val searchService: SearchService
) {
    @GetMapping("")
    fun findProductByTitle(@RequestParam title: String): Flux<Product> {
        return searchService.findProductByTitle(title)
    }

}