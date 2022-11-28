package com.siberia.market.inventory.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@IdClass(StockId::class)
@Table(indexes = [
    Index(name = "idx_stock_warehouse_uid", columnList = "warehouse_uid"),
    Index(name = "idx_stock_item_uid", columnList = "item_uid")
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
    val recordId: Int,

    @Enumerated
    val recordKind: RecordKind,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_uid")
    val item: Item,

    @Column(name = "item_count")
    val itemCount: Long
)
