package com.vinicius.estoque.domain;

import java.util.List;
import java.util.Objects;

public class Estoque {
    private Long id;
    private List<Produto> produtos;

    public Estoque() {
    }

    public Estoque(Long id, List<Produto> produtos) {
        this.id = id;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return id.equals(estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
