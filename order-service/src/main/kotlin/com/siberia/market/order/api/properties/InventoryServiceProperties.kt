package com.siberia.market.order.api.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "inventory-service")
data class InventoryServiceProperties(
    val serverUrl: String? = null
)
