package com.siberia.market.inventory.api

import java.util.*

data class ReserveItemsRequest(
    val orderUid: UUID,
    val itemsInfo: List<ItemInfo>
)

data class ItemInfo(
    val itemUid: UUID,
    val itemCount: Int
)