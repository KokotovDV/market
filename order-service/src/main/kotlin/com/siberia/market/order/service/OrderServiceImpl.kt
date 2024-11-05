package com.siberia.market.order.service

import com.siberia.market.order.MakeOrderRequest
import com.siberia.market.order.MakeOrderResponse
import com.siberia.market.order.exception.InventoryProcessException
import com.siberia.market.order.mapper.toMakeOrderResponse
import com.siberia.market.order.mapper.toOrder
import com.siberia.market.order.mapper.toReserveItemsRequest
import com.siberia.market.order.model.Order
import com.siberia.market.order.repository.OrderJpaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderServiceImpl(
    val orderJpaRepository: OrderJpaRepository,
    val inventoryService: InventoryService
) : OrderService {

    override fun makeOrder(makeOrderRequest: MakeOrderRequest): MakeOrderResponse {
        val orderUid = UUID.randomUUID()
        val reserveItemsRequest = makeOrderRequest.toReserveItemsRequest(orderUid)
        val reserveItemsResponse = inventoryService.reserveItems(reserveItemsRequest)
            .orElseThrow { InventoryProcessException("Can't reserve items") }
        val order = createOrder(makeOrderRequest, orderUid)
        return order.toMakeOrderResponse()
    }

    override fun createOrder(makeOrderRequest: MakeOrderRequest, orderUid: UUID): Order {
        val order = makeOrderRequest.toOrder(orderUid)
        return orderJpaRepository.save(order)
    }
}