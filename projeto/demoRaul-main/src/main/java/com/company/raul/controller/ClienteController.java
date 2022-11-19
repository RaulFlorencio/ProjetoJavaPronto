package com.company.raul.controller;



import com.company.raul.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.company.raul.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clRepo;


    @GetMapping(value = "/todos")
    public List<Cliente> buscarTodos()
    {
        return clRepo.findAll();
    }


    @GetMapping("/buscarPorCodigo/{codigo}")
    public Optional<Cliente> buscarPorCodigo
            (@PathVariable (value="codigo") int codigo)
    {
        return clRepo.findById(codigo);
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Cliente cl)
    {
        clRepo.save(cl);
    }

    @GetMapping("/porNome/{nome}")
    public List<Cliente> procurarPorNome(@PathVariable(value="nome") String nome)
    {
        return clRepo.findByNome(nome);
    }

    @GetMapping("/porEmail/{Email}")
    public List<Cliente> procurarPorEmail(@PathVariable(value="Email") String email)
    {
        return clRepo.findByEmail(email);
    }


    @DeleteMapping("/remover")
    public void removerCliente(@RequestBody Cliente cl)
    {
        clRepo.delete(cl);
    }

    @DeleteMapping("/removerPorCodigo/{codigo}")
    public void removerPorCodigo(@PathVariable(value="codigo") int codigo)
    {
        clRepo.deleteById(codigo);
    }


    @PutMapping("/atualizar")
    public void atualizarAluno(@RequestBody Cliente cl)
    {
        clRepo.save(cl);
    }
}