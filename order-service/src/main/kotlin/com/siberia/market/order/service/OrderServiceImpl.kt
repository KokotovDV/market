package com.siberia.market.order.service

import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.mapper.toMakeOrderResponse
import com.siberia.market.order.mapper.toOrder
import com.siberia.market.order.mapper.toReserveItemsRequest
import com.siberia.market.order.model.Order
import com.siberia.market.order.repository.OrderJpaRepository
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
        //val reserveItemsResponse = inventoryService.reserveItems(reserveItemsRequest)
        return order.toMakeOrderResponse()
    }

//    @Transactional



    override fun createOrder(makeOrderRequest: MakeOrderRequest): Order {
        val order = makeOrderRequest.toOrder()
        return orderJpaRepository.save(order)
    }
}