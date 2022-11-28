package com.siberia.market.inventory.model

import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_item_uid", columnList = "uid", unique = true)
])
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "uid", nullable = false)
    val uid: UUID? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null
)
