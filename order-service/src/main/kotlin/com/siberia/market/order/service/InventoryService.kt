package com.siberia.market.order.service

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.api.ReserveItemsResponse

interface InventoryService {
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse?
}