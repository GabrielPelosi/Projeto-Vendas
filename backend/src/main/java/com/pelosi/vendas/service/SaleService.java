package com.pelosi.vendas.service;

import com.pelosi.vendas.dto.SaleDTO;
import com.pelosi.vendas.dto.SaleSuccessDTO;
import com.pelosi.vendas.dto.SaleSumDTO;
import com.pelosi.vendas.dto.SellerDTO;
import com.pelosi.vendas.repository.SaleRepository;
import com.pelosi.vendas.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)//garante de que toda operacao é resolvida aqui, e o read only n faz lock de escrita no banco
    public Page<SaleDTO> findAllSales(Pageable pageable){
        sellerRepository.findAll(); //busca e salva em cache para o jpa não precisar ir buscar os sellers para as outras paginas
        return repository.findAll(pageable).map(sale -> new SaleDTO(
                sale.getId(),sale.getVisited(),sale.getDeals(),
                sale.getAmount(),sale.getDate(),
                new SellerDTO(sale.getSeller().getId(),sale.getSeller().getName())));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupBySeller(){
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupBySeller(){
        return repository.successGroupedBySeller();
    }


}
