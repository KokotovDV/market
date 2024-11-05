package com.siberia.market.order.service

import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.model.Order
import java.util.*

interface OrderService {
    fun makeOrder(makeOrderRequest: MakeOrderRequest): MakeOrderResponse
    fun createOrder(makeOrderRequest: MakeOrderRequest, orderUid: UUID): Order
}