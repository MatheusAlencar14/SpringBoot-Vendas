package com.dev.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data //Lombok: Cria Get, Set, toString, HashCode e Equals...
@NoArgsConstructor //Lombok: Cria construtor sem argumentos
@AllArgsConstructor //Lombok: Cria construtor com argumentos
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "preco_unitario")
    private BigDecimal preco;

}
