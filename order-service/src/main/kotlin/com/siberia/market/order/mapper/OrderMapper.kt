package com.siberia.market.order.mapper

import com.siberia.market.inventory.api.ItemInfo
import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.model.Order
import com.siberia.market.order.model.OrderItem
import java.time.LocalDateTime
import java.util.*

fun MakeOrderRequest.toReserveItemsRequest(orderUid: UUID): ReserveItemsRequest {
    return ReserveItemsRequest(
        orderUid = orderUid,
        itemsInfo = itemsInfo.map {
            ItemInfo(itemUid = it.itemUid, itemCount = it.itemCount)
        }
    )
}

fun MakeOrderRequest.toOrder(orderUid: UUID): Order {
    val order = Order(
        uid =  orderUid,
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
    order.items.map { it.order = order }
    return order
}

fun Order.toMakeOrderResponse(): MakeOrderResponse {
    return MakeOrderResponse(uid)
}
