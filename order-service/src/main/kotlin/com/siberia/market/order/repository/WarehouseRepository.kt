package com.siberia.market.order.repository

import com.siberia.market.order.model.Warehouse
import org.springframework.data.jpa.repository.JpaRepository

interface WarehouseRepository : JpaRepository<Warehouse, String>