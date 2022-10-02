package com.siberia.market.product.controller

import com.siberia.market.product.domain.Product
import com.siberia.market.product.service.ProductService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/product")
class ProductController(
    private val productService: ProductService
) {
    @GetMapping("")
    fun findAllProducts(): Flux<Product> {
        return productService.findAllProducts()
    }

    @GetMapping("/{id}")
    fun findProductById(@PathVariable("id") id: String): Mono<Product> {
        return productService.findProductById(id)
    }

    @GetMapping("/byTitle")
    fun findProductByTitle(@RequestParam title: String): Flux<Product> {
        return productService.findProductByTitle(title)
    }

    @PostMapping("")
    fun createProduct(@RequestBody product: Product): Mono<Product> {
        return productService.createProduct(product)
    }

    @PostMapping("/list")
    fun createProducts(@RequestBody products: List<Product>): Flux<Product> {
        return productService.createProducts(products)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable("id") id: String, @RequestBody product: Product): Mono<Product> {
        return productService.updateProduct(id, product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: String): Mono<Void> {
        return productService.deleteProduct(id)
    }
}