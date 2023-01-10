package com.vinicius.estoque.repository;

import com.vinicius.estoque.domain.Estoque;
import com.vinicius.estoque.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
}
