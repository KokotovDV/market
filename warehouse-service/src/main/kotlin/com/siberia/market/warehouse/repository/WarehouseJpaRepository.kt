package com.siberia.market.warehouse.repository

import com.siberia.market.warehouse.model.Warehouse
import org.springframework.data.jpa.repository.JpaRepository

interface WarehouseJpaRepository : JpaRepository<Warehouse, String>