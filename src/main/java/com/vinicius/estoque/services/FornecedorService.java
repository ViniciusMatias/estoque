package com.vinicius.estoque.services;

import com.vinicius.estoque.domain.Fornecedor;
import com.vinicius.estoque.repository.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedorById(Long id) throws Exception {
        if(fornecedorRepository.existsById(id)){
            return fornecedorRepository.findById(id).get();
        }
        throw new Exception("Fornecedor inexistente");
    }

    public List<Fornecedor> getAllFornecedores(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor createFornecedor(Fornecedor fornecedor){
       return fornecedorRepository.save(fornecedor);
    }

    public void deleteFornecedorById(Long id){
        try {
            Fornecedor fornecedorDeletado = getFornecedorById(id);
            fornecedorRepository.deleteById(fornecedorDeletado.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fornecedor updateFornecedorById(Long id, Fornecedor novoFornecedor){
        try {
            Fornecedor fornecedor = getFornecedorById(id);

            BeanUtils.copyProperties(novoFornecedor,fornecedor, "id");

            return this.fornecedorRepository.save(fornecedor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
