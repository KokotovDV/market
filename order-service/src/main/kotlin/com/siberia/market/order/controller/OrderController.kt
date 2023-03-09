package com.siberia.market.order.controller

import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.model.Order
import com.siberia.market.order.service.OrderServiceImpl
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/order")
class OrderController(
    private val orderService: OrderServiceImpl
) {
    @GetMapping
    fun findAllProducts(): String {
        return "order test"
    }

    @PostMapping
    fun makeOrder(@RequestBody makeOrderRequest: MakeOrderRequest): MakeOrderResponse {
        return orderService.makeOrder(makeOrderRequest)
    }

    @PostMapping
    fun createOrder(@RequestBody makeOrderRequest: MakeOrderRequest): Order {
        return orderService.createOrder(makeOrderRequest)
    }
}