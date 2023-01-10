package com.vinicius.estoque.repository;

import com.vinicius.estoque.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Estoque,Long> {
}
