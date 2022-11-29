package com.user.control.repository;

import  com.user.control.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuariosRepository extends JpaRepository<usuarios, Long> {
}
