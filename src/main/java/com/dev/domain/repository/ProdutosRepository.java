package com.dev.domain.repository;

import com.dev.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository <Produto, Integer> {
}
