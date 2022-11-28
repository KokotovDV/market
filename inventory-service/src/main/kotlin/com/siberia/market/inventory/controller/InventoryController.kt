package com.siberia.market.inventory.controller

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.api.ReserveItemsResponse
import com.siberia.market.inventory.service.InventoryService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/warehouse")
open class InventoryController(
    private val inventoryService: InventoryService
) {

    @PostMapping("")
    fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse {
        return inventoryService.reserveItems(reserveItemsRequest)
    }

}