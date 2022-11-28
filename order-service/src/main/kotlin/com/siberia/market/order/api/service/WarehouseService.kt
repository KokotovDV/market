package com.siberia.market.order.api.service

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.api.ReserveItemsResponse

interface WarehouseService {
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse?
}