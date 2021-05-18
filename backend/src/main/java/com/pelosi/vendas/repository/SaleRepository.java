package com.pelosi.vendas.repository;

import com.pelosi.vendas.dto.SaleSuccessDTO;
import com.pelosi.vendas.dto.SaleSumDTO;
import com.pelosi.vendas.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT new com.pelosi.vendas.dto.SaleSumDTO(obj.seller,SUM( obj.amount)) " +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.pelosi.vendas.dto.SaleSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals)) " +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();

}
