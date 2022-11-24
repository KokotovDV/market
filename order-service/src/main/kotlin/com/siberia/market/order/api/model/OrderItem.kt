package com.siberia.market.order.api.model

import java.util.UUID
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_order_item_order_item_uid", columnList = "order_item_uid", unique = true),
    Index(name = "idx_order_item_order_uid", columnList = "order_uid"),
    Index(name = "idx_order_item_item_uid", columnList = "item_uid")
])
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_item_uid", nullable = false)
    val orderItemUid: UUID,

    @Column(name = "order_uid", nullable = false)
    val orderUid: UUID,

    @Column(name = "item_uid", nullable = false)
    val itemUid: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_uid", insertable = false, updatable = false)
    val item: Item? = null,

    @Column(name = "item_count", nullable = false)
    val itemCount: Int
)