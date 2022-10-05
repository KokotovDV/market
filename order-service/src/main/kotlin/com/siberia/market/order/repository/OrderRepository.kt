package com.siberia.market.order.repository

import com.siberia.market.order.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, String>