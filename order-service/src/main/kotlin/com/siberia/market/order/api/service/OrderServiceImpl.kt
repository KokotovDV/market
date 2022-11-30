package com.siberia.market.order.api.service

import com.siberia.market.order.api.MakeOrderRequest
import com.siberia.market.order.api.MakeOrderResponse
import com.siberia.market.order.api.mapper.toMakeOrderResponse
import com.siberia.market.order.api.mapper.toOrder
import com.siberia.market.order.api.mapper.toReserveItemsRequest
import com.siberia.market.order.api.model.Order
import com.siberia.market.order.api.repository.OrderJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    val orderJpaRepository: OrderJpaRepository,
    val inventoryService: InventoryService
) : OrderService {

    override fun makeOrder(makeOrderRequest: MakeOrderRequest): MakeOrderResponse {
        val order = createOrder(makeOrderRequest)
        val reserveItemsRequest = order.toReserveItemsRequest()
        val reserveItemsResponse = inventoryService.reserveItems(reserveItemsRequest)
        return order.toMakeOrderResponse()
    }

    @Transactional
    override fun createOrder(makeOrderRequest: MakeOrderRequest): Order {
        val order = makeOrderRequest.toOrder()
        return orderJpaRepository.save(order)
    }
}