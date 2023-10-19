package com.dev.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Mapeando que essa é uma entidade no JPA
@Table(name = "cliente") //Indicando qual o nome da tabela no Banco de Dados
public class Cliente {

    @Id //Mapeando que esse atributo é um ID
    @GeneratedValue(strategy = GenerationType.AUTO) //Indicando a estratégia de auto incremento
    @Column(name = "id") //Indicando o nome da coluna (como é o mesmo nome, não seria necessário)
    private Integer id;

    @Column(name = "nome", length = 100) //Indicando o nome e o tamanho
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonIgnore //Ignora esse parâmetro no JSON
    @OneToMany(mappedBy = "cliente") //relacionamento um para muitos. mappedBy mapeia a propriedade cliente
    private Set<Pedido> pedidos; //fazendo uma lista de pedidos e mapeando com JPA

}
