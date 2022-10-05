package com.siberia.market.order.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Warehouse(
    @Id
    val id: Long,

    @Column(name = "warehouse_uid", nullable = false, unique = true)
    val warehouseUid: UUID? = null,

    val name: String
)

