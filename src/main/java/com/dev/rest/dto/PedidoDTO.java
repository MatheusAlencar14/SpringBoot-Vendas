package com.dev.rest.dto;

import com.dev.validation.NotEmptyList;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO { //DTO: Data Transfer Object

    @NotNull(message = "O Código do cliente é obrigatório!")
    private Integer cliente;

    @NotNull(message = "O campo Total é obrigatório!")
    private BigDecimal total;

    @NotEmptyList(message = "O Pedido não pode ser realizado sem Itens!")
    private List<ItemPedidoDTO> itens;
}
