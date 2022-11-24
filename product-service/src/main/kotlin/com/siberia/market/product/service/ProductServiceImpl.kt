package com.siberia.market.product.service

import com.siberia.market.product.model.Product
import com.siberia.market.product.repository.ProductMongoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductServiceImpl(
    private val productMongoRepository: ProductMongoRepository
) : ProductService {

    override fun findAllProducts(): Flux<Product> {
        return productMongoRepository.findAll()
    }

    override fun findProductById(id: String): Mono<Product> {
        return productMongoRepository.findById(id)
    }

    override fun findProductByTitle(title: String): Flux<Product> {
        return productMongoRepository.findByTitle(title)
    }

    override fun createProduct(product: Product): Mono<Product> {
        return productMongoRepository.save(product)
    }

    override fun createProducts(products: List<Product>): Flux<Product> {
        return productMongoRepository.saveAll(products)
    }

    override fun updateProduct(id: String, product: Product): Mono<Product> {
        return productMongoRepository.findById(id)
            .map {
                it.copy(
                    title = product.title,
                    description = product.description
                )
            }
            .flatMap { productMongoRepository.save(it) }
    }

    override fun deleteProduct(id: String): Mono<Void> {
        return productMongoRepository.deleteById(id)
    }

}