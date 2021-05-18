package com.pelosi.vendas.dto;


import com.pelosi.vendas.entity.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleSuccessDTO {

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
        this.sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
