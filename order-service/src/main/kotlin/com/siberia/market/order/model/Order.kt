package com.siberia.market.order.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_uid", nullable = false, unique = true)
    val orderUid: UUID? = null,

    @Column(name = "order_date", nullable = false)
    val orderDate: LocalDateTime,

    @OneToMany
    @JoinColumn(name = "order_item_uid")
    val items: List<OrderItem>
)
