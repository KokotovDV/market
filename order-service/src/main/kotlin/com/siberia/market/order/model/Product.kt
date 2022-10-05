package com.siberia.market.order.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Product(
    @Id
    val id: Long? = null,

    @Column(name = "product_uid", nullable = false, unique = true)
    val productUid: UUID? = null,

    val name: String? = null
)
