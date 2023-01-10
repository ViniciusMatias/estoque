package com.vinicius.estoque.repository;

import com.vinicius.estoque.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
