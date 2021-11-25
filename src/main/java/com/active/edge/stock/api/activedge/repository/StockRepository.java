package com.active.edge.stock.api.activedge.repository;

import com.active.edge.stock.api.activedge.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
