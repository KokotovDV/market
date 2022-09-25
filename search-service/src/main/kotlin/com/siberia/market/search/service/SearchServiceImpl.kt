package com.siberia.market.search.service

import com.siberia.market.search.domain.Product
import com.siberia.market.search.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SearchServiceImpl(
    private val productRepository: ProductRepository
) : SearchService {

    override fun findAll(): Flux<Product> {
        return productRepository.findAll()
    }

    override fun findById(id: String): Mono<Product> {
        return productRepository.findById(id)
    }

    override fun findByTitle(title: String): Flux<Product> {
        return productRepository.findByTitle(title)
    }

    override fun create(product: Product): Mono<Product> {
        return productRepository.save(product)
    }

    override fun delete(id: String): Mono<Void> {
        return productRepository.deleteById(id)
    }

}