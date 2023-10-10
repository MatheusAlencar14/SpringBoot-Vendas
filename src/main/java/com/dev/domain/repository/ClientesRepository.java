package com.dev.domain.repository;

import ch.qos.logback.core.net.server.Client;
import com.dev.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    //Todos os métodos já estão prontos na interface JpaRepository

    //Por ser bem específico, esse método precisará ser implementado **QueryMethods
    List<Cliente> findByNomeLike(String nome);

}
