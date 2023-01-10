package com.vinicius.estoque.controller;

import com.vinicius.estoque.domain.Fornecedor;
import com.vinicius.estoque.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll(){
        return ResponseEntity.ok(fornecedorService.getAllFornecedores());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorSalvo = fornecedorService.createFornecedor(fornecedor);
        return new ResponseEntity<>(fornecedorSalvo, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.fornecedorService.deleteFornecedorById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor novoFornecedor){
        Fornecedor fornecedor = this.fornecedorService.updateFornecedorById(id,novoFornecedor);
        return ResponseEntity.ok(fornecedor);
    }

}
