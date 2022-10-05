package com.siberia.market.order.repository

import com.siberia.market.order.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>