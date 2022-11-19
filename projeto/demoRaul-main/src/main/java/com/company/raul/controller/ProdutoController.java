package com.company.raul.controller;

import com.company.raul.model.Produto;
import com.company.raul.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apiProduto")
public class ProdutoController {
    @Autowired
    ProdutoRepository prRepo;


    @GetMapping(value = "/todos")
    public List<Produto> buscarTodos()
    {
        return prRepo.findAll();
    }


    @GetMapping("/buscarPorCodigo/{codigoProd}")
    public Optional<Produto> buscarPorCodigo
            (@PathVariable(value="codigoProd") int codigoProd)
    {
        return prRepo.findById(codigoProd);
    }

    @GetMapping("/buscarPorInfo/{inf}")
    public List<Produto> procurarPorInfo(@PathVariable(value="inf") String inf)
    {
        return prRepo.findByInf(inf);
    }
    @GetMapping("/buscarPorMarca/{marca}")
    public Optional<Produto> buscarPorMarca
            (@PathVariable(value="marca") String marca)
    {
        return prRepo.findByMarca(marca);

    }
    @GetMapping("/buscarPorPreco/{preco}")
    public List<Produto> buscarPorPreco
            (@PathVariable(value="preco") int preco)
    {
        return prRepo.findByPreco(preco);
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Produto pr)
    {
        prRepo.save(pr);
    }
    //Nao sei usar
    @DeleteMapping("/remover")
    public void removerProduto(@RequestBody Produto pr)
    {
        prRepo.delete(pr);
    }

    @DeleteMapping("/removerPorCodigo/{codigo}")
    public void removerPorCodigo(@PathVariable(value="codigo") int codigo)
    {
        prRepo.deleteById(codigo);
    }


    @PutMapping("/atualizar")
    public void atualizarAluno(@RequestBody Produto pr)
    {
        prRepo.save(pr);
    }
}


