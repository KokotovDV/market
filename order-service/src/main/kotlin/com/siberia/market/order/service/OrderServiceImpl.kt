package com.siberia.market.order.service

import com.siberia.market.order.api.CreateOrderRequest
import com.siberia.market.order.mapper.toOrder
import com.siberia.market.order.model.Order
import com.siberia.market.order.repository.OrderRepository
import com.siberia.market.order.repository.StockRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val stockRepository: StockRepository
) : OrderService{

    @Transactional
    override fun createOrder(createOrderRequest: CreateOrderRequest): Order {

        val order = createOrderRequest.toOrder()
        return orderRepository.save(order)
//        val stock = Stock(
//            registrationDate = LocalDateTime.now(),
//            documentType = DocumentType.Order,
//            documentId =
//        )
//        stockRepository.save()
//        //1 create record in table WarehouseStock with -count
//        //2
//        return orderRepository.save(order)
    }
}