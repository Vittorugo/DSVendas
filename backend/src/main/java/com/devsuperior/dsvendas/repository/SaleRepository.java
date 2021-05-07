package com.devsuperior.dsvendas.repository;

import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> , PagingAndSortingRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount)) " +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SalesSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SalesSuccessDTO> successGroupedBySeller();
}
