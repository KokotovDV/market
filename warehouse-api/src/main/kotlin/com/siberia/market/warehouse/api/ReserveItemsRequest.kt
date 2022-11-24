package com.siberia.market.warehouse.api

import java.util.*

data class ReserveItemsRequest(
    val orderUid: UUID,
    val itemsInfo: List<ItemsInfo>
)

data class ItemsInfo(
    val itemsUid: UUID,
    val itemsCount: Int
)