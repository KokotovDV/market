package com.siberia.market.search.controller

import com.siberia.market.search.domain.Product
import com.siberia.market.search.service.SearchService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("api/v1/search")
class SearchController(
    private val searchService: SearchService
) {
    @GetMapping("")
    fun findAll(): Flux<Product> {
        return searchService.findAll()
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): Mono<Product> {
        return searchService.findById(id)
    }

    @GetMapping("/byTitle")
    fun findByTitle(@RequestParam title: String): Flux<Product> {
        return searchService.findByTitle(title)
    }

    @PostMapping("")
    fun create(@RequestBody product: Product): Mono<Product> {
        return searchService.create(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) : Mono<Void> {
        return searchService.delete(id)
    }
}