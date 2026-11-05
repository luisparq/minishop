package com.tecsup.minishop.repository;

import com.tecsup.minishop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Proporciona las operaciones de acceso a la base de datos.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Busca productos cuyo nombre contenga el texto, ignorando mayúsculas.
    List<Product> findByNameContainingIgnoreCase(String name);
}