package com.siberia.market.order.model

import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_product_product_uid", columnList = "product_uid", unique = true)
])
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "product_uid", nullable = false)
    val productUid: UUID? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null
)
