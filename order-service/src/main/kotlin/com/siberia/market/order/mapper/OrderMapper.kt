package com.siberia.market.order.mapper

import com.siberia.market.order.api.CreateOrderRequest
import com.siberia.market.order.model.Order
import com.siberia.market.order.model.OrderItem
import java.time.LocalDateTime
import java.util.*

fun CreateOrderRequest.toOrder(): Order {
    val orderUid = UUID.randomUUID()
    return Order(
        orderUid = orderUid,
        orderDate = LocalDateTime.now(),
        items = productsInfo.map {
            OrderItem(
                orderUid = orderUid,
                orderItemUid = UUID.randomUUID(),
                productUid = it.productUid,
                productCount = it.productCount
            )
        }
    )
}