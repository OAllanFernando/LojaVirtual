package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;


@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir (Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
        
    }

    public List<Pessoa> buscarPessoaPorNome(String nome){
        return pessoaRepository.buscaPessoaPorNome(nome);
    }

}
