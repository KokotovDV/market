package com.siberia.market.warehouse.service

import com.siberia.market.warehouse.api.ReserveItemsRequest
import com.siberia.market.warehouse.api.ReserveItemsResponse
import com.siberia.market.warehouse.repository.ItemJpaRepository
import com.siberia.market.warehouse.repository.StockJpaRepository
import com.siberia.market.warehouse.repository.WarehouseJpaRepository

class WarehouseServiceImpl(
    itemJpaRepository: ItemJpaRepository,
    stockJpaRepository: StockJpaRepository,
    warehouseJpaRepository: WarehouseJpaRepository
) : WarehouseService {

    override fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse {
        return ReserveItemsResponse(true)
    }

}