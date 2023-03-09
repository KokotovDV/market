package com.siberia.market.order.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "inventory-service")
data class InventoryServiceProperties(
    val serverUrl: String? = null
)
