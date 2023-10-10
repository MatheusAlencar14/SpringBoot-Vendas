package com.dev.domain.repository;

import com.dev.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    //Todos os métodos já estão prontos na interface JpaRepository

    //Por ser bem específico, esse método precisará ser implementado **QueryMethods
    List<Cliente> findByNomeLike(String nome);

    //Retorna se há ou não um nome no BD
    boolean existsByNome (String nome);

}
