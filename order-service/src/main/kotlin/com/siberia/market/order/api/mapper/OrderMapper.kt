package com.siberia.market.order.api.mapper

import com.siberia.market.inventory.api.ItemInfo
import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.order.api.MakeOrderRequest
import com.siberia.market.order.api.MakeOrderResponse
import com.siberia.market.order.api.model.Order
import com.siberia.market.order.api.model.OrderItem
import java.time.LocalDateTime
import java.util.*

fun MakeOrderRequest.toOrder(): Order {
    val orderUid = UUID.randomUUID()
    return Order(
        uid = orderUid,
        orderDate = LocalDateTime.now(),
        items = itemsInfo.map {
            OrderItem(
                orderUid = orderUid,
                orderItemUid = UUID.randomUUID(),
                itemUid = it.itemUid,
                itemCount = it.itemCount
            )
        }
    )
}

fun Order.toMakeOrderResponse(): MakeOrderResponse {
    return MakeOrderResponse(uid)
}

fun Order.toReserveItemsRequest(): ReserveItemsRequest {
    return ReserveItemsRequest(
        orderUid = uid,
        itemsInfo = items.map {
            ItemInfo(itemUid = it.itemUid, itemCount = it.itemCount)
        }
    )
}