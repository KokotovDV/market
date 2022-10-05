package com.siberia.market.order.model

import java.util.UUID
import javax.persistence.*

@Entity
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_uid", nullable = false, unique = true)
    val orderUid: UUID? = null,

    @Column(name = "order_item_uid", nullable = false, unique = true)
    val orderItemUid: UUID? = null,

    @Column(name = "product_uid", nullable = false, unique = true)
    val productUid: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_uid", nullable = false)
    val product: Product? = null,

    @Column(name = "product_count", nullable = false)
    val productCount: Long? = null
)