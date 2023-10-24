package com.dev.rest.controller;

import com.dev.domain.entity.Produto;
import com.dev.domain.repository.ProdutosRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        return produtosRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado!"
                ));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@RequestBody @Valid Produto produto) {
        return produtosRepository.save(produto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdutoById(@PathVariable Integer id) {
        produtosRepository
                .findById(id)
                .map(produto -> {
                    produtosRepository.delete(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"
                ));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduto(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
        produtosRepository
                .findById(id)
                .map(produtoExist -> {
                    produto.setId(produtoExist.getId());
                    produtosRepository.save(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }

    @GetMapping("/filter")
    public List<Produto> find(Produto filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);
        return produtosRepository.findAll(example);
    }
}
