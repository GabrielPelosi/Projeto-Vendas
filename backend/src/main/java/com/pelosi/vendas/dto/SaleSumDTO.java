package com.pelosi.vendas.dto;


import com.pelosi.vendas.entity.Seller;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SaleSumDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double sum;

    public SaleSumDTO(Seller seller, Double sum){
        this.name = seller.getName();
        this.sum=sum;
    }

}
