package com.siberia.market.order.model

import StockId
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@IdClass(StockId::class)
data class Stock(
    @Id
    val registrationDate: LocalDateTime,

    @Id
    val documentType: DocumentType,

    @Id
    val documentId: String,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_uid")
    val warehouse: Warehouse,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_uid")
    val product: Product,

    @Column(name = "product_count")
    val productCount: Long
)
