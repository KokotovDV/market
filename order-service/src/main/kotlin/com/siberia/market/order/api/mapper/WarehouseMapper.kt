package com.siberia.market.order.api.mapper

import com.siberia.market.order.api.model.Order
import com.siberia.market.warehouse.api.ItemsInfo
import com.siberia.market.inventory.api.ReserveItemsRequest

fun Order.toReserveItemsRequest(): ReserveItemsRequest {
    return ReserveItemsRequest(
        orderUid = orderUid,
        itemsInfo = items.map {
            ItemsInfo(itemsUid = it.itemUid, itemsCount = it.itemCount)
        }
    )
}