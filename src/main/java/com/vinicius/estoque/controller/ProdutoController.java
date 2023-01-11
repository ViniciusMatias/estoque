package com.vinicius.estoque.controller;

import com.vinicius.estoque.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;


}
