package com.siberia.market.order.repository

import com.siberia.market.order.model.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository : JpaRepository<Stock, String>