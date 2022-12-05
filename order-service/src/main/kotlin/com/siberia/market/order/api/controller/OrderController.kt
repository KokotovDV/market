package com.siberia.market.order.api.controller

import com.siberia.market.order.api.MakeOrderRequest
import com.siberia.market.order.api.MakeOrderResponse
import com.siberia.market.order.api.service.OrderServiceImpl
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

}