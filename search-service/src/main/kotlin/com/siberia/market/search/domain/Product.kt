package com.siberia.market.search.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class Product(
    @Id
    val id: String,
    val title: String,
    val description: String
)
