package com.siberia.market.search.service

import com.siberia.market.search.domain.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface SearchService {

    fun findAll(): Flux<Product>

    fun findById(id: String): Mono<Product>

    fun findByTitle(title: String): Flux<Product>

    fun create(product: Product): Mono<Product>

    fun delete(id: String): Mono<Void>

}