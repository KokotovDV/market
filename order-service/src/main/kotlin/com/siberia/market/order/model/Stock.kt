package com.siberia.market.order.model

import StockId
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@IdClass(StockId::class)
@Table(indexes = [
    Index(name = "idx_stock_warehouse_uid", columnList = "warehouse_uid"),
    Index(name = "idx_stock_product_uid", columnList = "product_uid")
])
data class Stock(
    @Id
    val registrationDate: LocalDateTime,

    @Id
    @Enumerated
    val documentType: DocumentType,

    @Id
    val documentId: UUID,

    @Id
    val rowId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_uid")
    val warehouse: Warehouse,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_uid")
    val product: Product,

    @Column(name = "product_count")
    val productCount: Long
)
