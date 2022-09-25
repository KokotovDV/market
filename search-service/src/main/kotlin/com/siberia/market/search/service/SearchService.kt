package com.siberia.market.search.service

import com.siberia.market.search.domain.Product
import reactor.core.publisher.Flux

interface SearchService {
    fun findProductByTitle(title: String): Flux<Product>
}