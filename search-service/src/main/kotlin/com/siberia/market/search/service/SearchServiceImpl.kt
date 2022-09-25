package com.siberia.market.search.service

import com.siberia.market.search.domain.Product
import com.siberia.market.search.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SearchServiceImpl(
    private val productRepository: ProductRepository
) : SearchService {
    override fun findProductByTitle(title: String): Flux<Product> {
        return productRepository.findByTitle(title)
    }
}