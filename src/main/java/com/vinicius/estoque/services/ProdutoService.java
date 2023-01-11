package com.vinicius.estoque.services;

import com.vinicius.estoque.domain.Fornecedor;
import com.vinicius.estoque.domain.Produto;
import com.vinicius.estoque.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto getProdutoById(Long id) throws Exception {
        if(produtoRepository.existsById(id)){
            return produtoRepository.findById(id).get();
        }
        throw new Exception("Produto inexistente");
    }

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    public Produto createProduto (Produto produto){
        return produtoRepository.save(produto);
    }

    public void deleteProdutoById(Long id){
        try {
            Produto produtoDeletado = getProdutoById(id);
            produtoRepository.deleteById(produtoDeletado.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Produto updateProdutoById(Long id, Produto novoProduto){
        try {
            Produto produto = getProdutoById(id);

            BeanUtils.copyProperties(novoProduto,produto, "id");

            return this.produtoRepository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
