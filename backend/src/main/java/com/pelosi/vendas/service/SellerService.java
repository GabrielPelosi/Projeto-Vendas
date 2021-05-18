package com.pelosi.vendas.service;

import com.pelosi.vendas.dto.SellerDTO;
import com.pelosi.vendas.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerService {
    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAllSellers(){
        return repository.findAll().stream()
                .map(seller -> new SellerDTO(seller.getId(), seller.getName()))
                .collect(Collectors.toList());
    }
}
