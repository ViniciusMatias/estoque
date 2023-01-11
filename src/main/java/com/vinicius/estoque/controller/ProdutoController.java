package com.vinicius.estoque.controller;

import com.vinicius.estoque.domain.Fornecedor;
import com.vinicius.estoque.domain.Produto;
import com.vinicius.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoService.getAllProdutos());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.createProduto(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.produtoService.deleteProdutoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto novoProduto){
        Produto produto = this.produtoService.updateProdutoById(id,novoProduto);
        return ResponseEntity.ok(produto);
    }


}
