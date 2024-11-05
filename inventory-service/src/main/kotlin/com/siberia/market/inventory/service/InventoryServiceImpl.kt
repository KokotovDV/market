package com.siberia.market.inventory.service

import com.siberia.market.inventory.api.ReserveItemsRequest
import com.siberia.market.inventory.api.ReserveItemsResponse
import com.siberia.market.inventory.mapper.toStocks
import com.siberia.market.inventory.model.Item
import com.siberia.market.inventory.repository.ItemJpaRepository
import com.siberia.market.inventory.repository.StockJpaRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class InventoryServiceImpl(
    val itemJpaRepository: ItemJpaRepository,
    val stockJpaRepository: StockJpaRepository
) : InventoryService {

    @Transactional
    override fun reserveItems(reserveItemsRequest: ReserveItemsRequest): ReserveItemsResponse {

        val itemUIDs = reserveItemsRequest.itemsInfo.map { it.itemUid }
        val items = findItemsByUIDs(itemUIDs)
        val registrationDate = LocalDateTime.now(ZoneOffset.UTC);
        val stocks = reserveItemsRequest.toStocks(items, registrationDate)

        stockJpaRepository.saveAll(stocks)


        //check

        /*
        on enter uuid order, uuid item, item count
        0. create List<Stock>
        1. List<Stock>.saveAll()
        2. check available count, if balance is negative, then rollback transaction
        3.
        */


        return ReserveItemsResponse(true)
    }

    override fun findItemsByUIDs(itemUIDs: List<UUID>): List<Item> {
        val items = itemJpaRepository.findAllByUidIn(itemUIDs)
        val notFoundItemUIDs = itemUIDs.subtract(items.map { it.uid }.toSet())
        if (notFoundItemUIDs.isNotEmpty()) {
            throw EntityNotFoundException("Item not found for UIDs: '$notFoundItemUIDs'")
        }
        return items
    }
}

/*
 + 21.11.2022 10:01, Inventory, UUID_XX0, 1, Warehouse1, Notebook, 5
 + 21.11.2022 10:01, Inventory, UUID_XX0, 2, Warehouse1, CableA, 20
 + 21.11.2022 10:01, Inventory, UUID_XX0, 3, Warehouse1, CableB, 10
 - 26.11.2022 18:32, Order, UUID_XX1, 1, Warehouse1, Notebook, 1
 - 26.11.2022 18:32, Order, UUID_XX1, 2, Warehouse1, CableA, 2

*/

//data class Stock(
//    @Id
//    val registrationDate: LocalDateTime,
//
//    @Id
//    @Enumerated
//    val documentType: DocumentType,
//
//    @Id
//    val documentId: UUID,
//
//    @Id
//    val rowId: Int,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "warehouse_uid")
//    val warehouse: Warehouse,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_uid")
//    val item: Item,
//
//    @Column(name = "item_count")
//    val itemCount: Long
//)