package com.siberia.market.order.api.service

import com.siberia.market.warehouse.api.ReserveItemsRequest
import com.siberia.market.warehouse.api.ReserveItemsResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

@Service
class WarehouseServiceImpl(
    val warehouseWebClient: WebClient
): WarehouseService {
    override fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse? {
        return warehouseWebClient
            .post()
            .body(BodyInserters.fromValue(reserveItemsRequest))
            .retrieve()
            .bodyToMono(ReserveItemsResponse::class.java)
            .block()
    }
}