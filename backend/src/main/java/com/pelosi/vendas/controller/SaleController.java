package com.pelosi.vendas.controller;


import com.pelosi.vendas.dto.SaleDTO;
import com.pelosi.vendas.dto.SaleSuccessDTO;
import com.pelosi.vendas.dto.SaleSumDTO;
import com.pelosi.vendas.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {

    @Autowired
    private SaleService saleService;


    @GetMapping
    public ResponseEntity<Page<SaleDTO>> getAllSales(Pageable pageable){
        return ResponseEntity.ok(saleService.findAllSales(pageable));
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> getAmountGroupBySeller(){
        return ResponseEntity.ok(saleService.amountGroupBySeller());
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> getSuccessGroupBySeller(){
        return ResponseEntity.ok(saleService.successGroupBySeller());
    }

}
