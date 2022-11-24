package com.siberia.market.order.api.repository

import com.siberia.market.order.api.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemJpaRepository : JpaRepository<Item, String>