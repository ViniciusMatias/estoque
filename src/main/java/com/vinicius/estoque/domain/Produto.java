package com.vinicius.estoque.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    private Long id;
    private String nome;
    private Integer quatidadeProduto;
    private String marca;
    @OneToOne
    private Fornecedor fornecedor;
    private BigDecimal valorProd;
    @ManyToOne
    @JoinColumn(name = "venda_id",
    referencedColumnName = "id")
    private Estoque estoque;

    public Produto(Long id, String nome, Integer quatidadeProduto, String marca, Fornecedor fornecedor, BigDecimal valorProd, Estoque estoque) {
        this.id = id;
        this.nome = nome;
        this.quatidadeProduto = quatidadeProduto;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.valorProd = valorProd;
        this.estoque = estoque;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuatidadeProduto() {
        return quatidadeProduto;
    }

    public void setQuatidadeProduto(Integer quatidadeProduto) {
        this.quatidadeProduto = quatidadeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValorProd() {
        return valorProd;
    }

    public void setValorProd(BigDecimal valorProd) {
        this.valorProd = valorProd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
