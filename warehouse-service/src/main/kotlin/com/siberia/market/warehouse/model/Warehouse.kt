package com.siberia.market.warehouse.model

import java.util.*
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "idx_warehouse_warehouse_uid", columnList = "warehouse_uid", unique = true)
])
data class Warehouse(
    @Id
    val id: Long,

    @Column(name = "warehouse_uid", nullable = false)
    val warehouseUid: UUID? = null,

    @Column(name = "name", nullable = false)
    val name: String
)

