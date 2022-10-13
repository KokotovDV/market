package com.siberia.market.order.model

import java.util.UUID
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_order_item_order_item_uid", columnList = "order_item_uid", unique = true),
    Index(name = "idx_order_item_order_uid", columnList = "order_uid"),
    Index(name = "idx_order_item_product_uid", columnList = "product_uid")
])
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_item_uid", nullable = false)
    val orderItemUid: UUID? = null,

    @Column(name = "order_uid", nullable = false)
    val orderUid: UUID? = null,

    @Column(name = "product_uid", nullable = false)
    val productUid: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_uid", insertable = false, updatable = false)
    val product: Product? = null,

    @Column(name = "product_count", nullable = false)
    val productCount: Int? = null
)