package com.siberia.market.inventory.model

import java.io.Serializable
import java.time.LocalDateTime
import jakarta.persistence.Id

data class StockId (
    @Id
    val registrationDate: LocalDateTime,

    @Id
    val documentType: DocumentType,

    @Id
    val documentId: String,

    @Id
    val recordId: String

) : Serializable