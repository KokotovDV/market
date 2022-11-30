package com.siberia.market.order.api.config

import com.siberia.market.order.api.properties.InventoryServiceProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@EnableConfigurationProperties(value = [InventoryServiceProperties::class])
class WebClientConfiguration {

    @Bean
    fun warehouseWebClient(properties: InventoryServiceProperties): WebClient {
        return WebClient.builder()
            .baseUrl("${properties.serverUrl}api/v1/warehouse")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
}