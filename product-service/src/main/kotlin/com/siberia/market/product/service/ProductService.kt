package com.siberia.market.product.service

import com.siberia.market.product.domain.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductService {

    fun findAllProducts(): Flux<Product>

    fun findProductById(id: String): Mono<Product>

    fun findProductByTitle(title: String): Flux<Product>

    fun createProduct(product: Product): Mono<Product>

    fun updateProduct(id: String, product: Product): Mono<Product>

    fun deleteProduct(id: String): Mono<Void>

}