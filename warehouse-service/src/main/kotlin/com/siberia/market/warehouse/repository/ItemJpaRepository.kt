package com.siberia.market.warehouse.repository

import com.siberia.market.warehouse.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemJpaRepository : JpaRepository<Item, String>