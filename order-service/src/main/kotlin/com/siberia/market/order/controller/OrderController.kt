package com.siberia.market.order.controller

import com.siberia.market.order.api.CreateOrderRequest
import com.siberia.market.order.model.Order
import com.siberia.market.order.service.OrderServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//import org.springframework.transaction.annotation.Transactional
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//import reactor.core.publisher.Mono

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
    //@Transactional
    fun createOrder(createOrderRequest: CreateOrderRequest): Order {
        return orderService.createOrder(createOrderRequest)
    }
}