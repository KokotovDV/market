package com.siberia.market.inventory.service

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.api.ReserveItemsResponse
import com.siberia.market.inventory.model.Item
import java.util.*

interface InventoryService {
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse
    fun findItemsByUIDs(itemUIDs: List<UUID>): List<Item>
}