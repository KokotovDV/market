package com.siberia.market.order.api.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "warehouse-service")
data class WarehouseServiceProperties(
    val serverUrl: String? = null
)
