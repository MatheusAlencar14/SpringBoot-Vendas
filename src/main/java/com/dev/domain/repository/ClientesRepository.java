package com.dev.domain.repository;

import com.dev.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    //Todos os métodos já estão prontos na interface JpaRepository

    //Por ser bem específico, esse método precisará ser implementado **QueryMethods
    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> findByNomeLike(@Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome =:nome ")
    @Modifying //Usar sempre que for delete ou update, pra dizer que está atualizando a tabela
    void deleteByNome(String nome); //Ele ja entende como QueryMethods

    //Retorna se há ou não um nome no BD
    boolean existsByNome (String nome);

}
