package com.pelosi.vendas.controller;


import com.pelosi.vendas.dto.SaleDTO;
import com.pelosi.vendas.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
