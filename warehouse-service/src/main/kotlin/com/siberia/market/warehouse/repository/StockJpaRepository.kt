package com.siberia.market.warehouse.repository

import com.siberia.market.warehouse.model.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface StockJpaRepository : JpaRepository<Stock, String>