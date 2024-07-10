package com.warehouse_stocks.demo.repositories;

import com.warehouse_stocks.demo.entities.StockID;
import com.warehouse_stocks.demo.entities.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, StockID> {
    @Query("SELECT SUM(s.quantity) FROM StockItem s WHERE s.stockId.articleId = (SELECT a.id FROM Article a WHERE a.name = :name)")
    Integer getQuantityOverAllLocationsByArticle(String name);
}
