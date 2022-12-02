package com.siberia.market.inventory.repository

import com.siberia.market.inventory.model.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import javax.persistence.LockModeType

interface StockJpaRepository : JpaRepository<Stock, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun <S : Stock> saveAll(entities: Iterable<S>): List<S>

}