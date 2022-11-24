package com.siberia.market.order.api

import java.util.*

data class MakeOrderRequest(
    val itemsInfo: List<ItemsInfo>
)

data class ItemsInfo(
    val itemUid: UUID,
    val itemCount: Int
)