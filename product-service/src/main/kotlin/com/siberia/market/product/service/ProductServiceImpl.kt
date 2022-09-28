package com.siberia.market.product.service

import com.siberia.market.product.domain.Product
import com.siberia.market.product.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {

    override fun findAllProducts(): Flux<Product> {
        return productRepository.findAll()
    }

    override fun findProductById(id: String): Mono<Product> {
        return productRepository.findById(id)
    }

    override fun findProductByTitle(title: String): Flux<Product> {
        return productRepository.findByTitle(title)
    }

    override fun createProduct(product: Product): Mono<Product> {
        return productRepository.save(product)
    }

    override fun updateProduct(id: String, product: Product): Mono<Product> {
        return productRepository.findById(id)
            .map {
                it.copy(
                    title = product.title,
                    description = product.description
                )
            }
            .flatMap { productRepository.save(it) }
    }

    override fun deleteProduct(id: String): Mono<Void> {
        return productRepository.deleteById(id)
    }

}