package com.siberia.market.warehouse.service

import com.siberia.market.warehouse.api.ReserveItemsRequest
import com.siberia.market.warehouse.api.ReserveItemsResponse

interface WarehouseService {
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse
}