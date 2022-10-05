package com.siberia.market.product.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class Product(
    @Id
    val id: String,
    var title: String,
    var description: String
)
