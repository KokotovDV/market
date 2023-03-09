package com.siberia.market.order.model

import java.time.LocalDateTime
import java.util.*
import jakarta.persistence.*

@Entity
@Table(
    name = "orders", indexes = [
        Index(name = "idx_orders_uid", columnList = "uid", unique = true)
    ]
)
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "uid", nullable = false, unique = true)
    val uid: UUID,

    @Column(name = "order_date", nullable = false)
    val orderDate: LocalDateTime,

    @OneToMany(mappedBy = "order", cascade=[CascadeType.ALL])
    val items: List<OrderItem>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (uid != other.uid) return false

        return true
    }

    override fun hashCode(): Int {
        return uid.hashCode()
    }

    override fun toString(): String {
        return "Order(id=$id, uid=$uid, orderDate=$orderDate)"
    }
}
