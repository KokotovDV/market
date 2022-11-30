package com.siberia.market.order.api.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders", indexes = [
    Index(name = "idx_order_uid", columnList = "uid", unique = true)
])
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "uid", nullable = false, unique = true)
    val uid: UUID,

    @Column(name = "date", nullable = false)
    val date: LocalDateTime,

    @OneToMany
    @JoinColumn(name = "order_item_uid")
    val items: List<OrderItem>
)
