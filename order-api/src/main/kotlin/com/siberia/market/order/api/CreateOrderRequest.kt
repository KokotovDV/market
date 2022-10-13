package com.siberia.market.order.api

import java.util.*

data class CreateOrderRequest(
    val productsInfo: List<ProductsInfo>
)

data class ProductsInfo(
    val productUid: UUID? = null,
    val productCount: Int? = null
)