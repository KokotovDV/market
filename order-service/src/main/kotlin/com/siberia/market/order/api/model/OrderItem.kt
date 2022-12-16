package com.siberia.market.order.api.model

import java.util.UUID
import jakarta.persistence.*

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null,

    @Column(name = "order_item_uid", nullable = false)
    val orderItemUid: UUID,

    @Column(name = "order_uid", nullable = false)
    val orderUid: UUID,

    @Column(name = "item_uid", nullable = false)
    val itemUid: UUID,

    @Column(name = "item_count", nullable = false)
    val itemCount: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderItem

        if (orderItemUid != other.orderItemUid) return false

        return true
    }

    override fun hashCode(): Int {
        return orderItemUid.hashCode()
    }

    override fun toString(): String {
        return "OrderItem(id=$id, order=$order, orderItemUid=$orderItemUid, orderUid=$orderUid, itemUid=$itemUid, itemCount=$itemCount)"
    }

}