package com.dev.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data //Lombok: Cria Get, Set, toString, HashCode e Equals...
@NoArgsConstructor //Lombok: Cria construtor sem argumentos
@AllArgsConstructor //Lombok: Cria construtor com argumentos
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao", length = 100)
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "{campo.preco.obrigatorio}") //Indica que o preço não é nulo
    private BigDecimal preco;

}
