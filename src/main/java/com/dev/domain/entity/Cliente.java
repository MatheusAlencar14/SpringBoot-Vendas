package com.dev.domain.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.Set;

@Entity //Mapeando que essa é uma entidade no JPA
@Table(name = "cliente") //Indicando qual o nome da tabela no Banco de Dados
public class Cliente {

    @Id //Mapeando que esse atributo é um ID
    @GeneratedValue(strategy = GenerationType.AUTO) //Indicando a estratégia de auto incremento
    @Column(name = "id") //Indicando o nome da coluna (como é o mesmo nome, não seria necessário)
    private Integer id;

    @Column(name = "nome", length = 100) //Indicando o nome e o tamanho
    private String nome;

    @OneToMany(mappedBy = "cliente") //relacionamento um para muitos. mappedBy mapeia a propriedade cliente
    private Set<Pedido> pedidos; //fazendo uma lista de pedidos e mapeando com JPA

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
