package com.siberia.market.order

import java.util.*

data class MakeOrderRequest(
    val itemsInfo: List<ItemInfo>
)

data class ItemInfo(
    val itemUid: UUID,
    val itemCount: Int
)