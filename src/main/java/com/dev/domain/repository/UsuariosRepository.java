package com.dev.domain.repository;

import com.dev.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
}
