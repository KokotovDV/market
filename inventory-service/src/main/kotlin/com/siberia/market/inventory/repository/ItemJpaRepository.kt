package com.siberia.market.inventory.repository

import com.siberia.market.inventory.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ItemJpaRepository : JpaRepository<Item, String> {
    fun findAllByUidIn(UIDs: List<UUID>): List<Item>
}