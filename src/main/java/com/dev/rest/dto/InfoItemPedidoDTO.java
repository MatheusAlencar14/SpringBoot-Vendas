package com.dev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoItemPedidoDTO {

    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
