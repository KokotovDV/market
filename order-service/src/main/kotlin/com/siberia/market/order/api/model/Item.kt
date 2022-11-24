package com.siberia.market.order.api.model

import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_item_item_uid", columnList = "item_uid", unique = true)
])
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "item_uid", nullable = false)
    val itemUid: UUID,

    @Column(name = "name", nullable = false)
    val name: String
)
