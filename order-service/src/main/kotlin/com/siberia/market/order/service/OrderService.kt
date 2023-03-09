package com.siberia.market.order.service

import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.model.Order

interface OrderService {
    fun makeOrder(makeOrderRequest: MakeOrderRequest): MakeOrderResponse
    fun createOrder(makeOrderRequest: MakeOrderRequest): Order
}