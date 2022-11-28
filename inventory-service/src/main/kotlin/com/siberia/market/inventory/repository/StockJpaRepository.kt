package com.siberia.market.inventory.repository

import com.siberia.market.inventory.model.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface StockJpaRepository : JpaRepository<Stock, String>