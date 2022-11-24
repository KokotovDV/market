package com.siberia.market.order.api.service

import com.siberia.market.order.api.MakeOrderRequest
import com.siberia.market.order.api.MakeOrderResponse
import com.siberia.market.order.api.model.Order

interface OrderService {
    fun makeOrder(makeOrderRequest: MakeOrderRequest): MakeOrderResponse
    fun createOrder(makeOrderRequest: MakeOrderRequest): Order
}