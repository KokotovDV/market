package com.siberia.market.order.service

import com.siberia.market.order.api.CreateOrderRequest
import com.siberia.market.order.model.Order

interface OrderService {
    fun createOrder(createOrderRequest: CreateOrderRequest): Order
}