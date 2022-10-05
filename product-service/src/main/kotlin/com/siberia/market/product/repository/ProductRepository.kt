package com.siberia.market.product.repository

import com.siberia.market.product.model.Product
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface ProductRepository : ReactiveMongoRepository<Product, String> {
    @Query(
        value = """
                    {
                         "title" : {
                             "${'$'}regularExpression" : { "pattern" : ?0, "options" : ""}
                         }
                    }
                    """,
        sort = """
                    {
                        "title" : 1 
                    }
                    """
    )
    fun findByTitle(title: String): Flux<Product>
}


