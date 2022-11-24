package com.siberia.market.search.controller

import com.siberia.market.warehouse.api.ReserveItemsRequest
import com.siberia.market.warehouse.api.ReserveItemsResponse
import com.siberia.market.warehouse.service.WarehouseService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/warehouse")
open class WarehouseController(
    private val warehouseService: WarehouseService
) {

    @PostMapping("")
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse {
        return warehouseService.reserveItems(reserveItemsRequest)
    }

}