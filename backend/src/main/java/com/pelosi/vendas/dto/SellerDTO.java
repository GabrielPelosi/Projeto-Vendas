package com.pelosi.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Slf4j
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;


}
