package com.siberia.market.order.api.repository

import com.siberia.market.order.api.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository : JpaRepository<Order, String>