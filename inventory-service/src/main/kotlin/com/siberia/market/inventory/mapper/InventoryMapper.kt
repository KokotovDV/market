package com.siberia.market.inventory.mapper

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.model.DocumentType
import com.siberia.market.inventory.model.Item
import com.siberia.market.inventory.model.RecordKind
import com.siberia.market.inventory.model.Stock
import java.time.LocalDateTime
import java.time.ZoneOffset

fun ReserveItemsRequest.toStocks(items: List<Item>): List<Stock> {
    val registrationDate = LocalDateTime.now(ZoneOffset.UTC);
    return itemsInfo.map { itemInfo ->
        Stock(
            registrationDate = registrationDate,
            documentType = DocumentType.Order,
            documentId = orderUid,
            recordId = itemsInfo.indexOf(itemInfo) + 1,
            recordKind = RecordKind.Expense,
            item = items.first { item -> item.uid == itemInfo.itemUid },
            itemCount = itemInfo.itemCount.toLong()
        )
    }
}