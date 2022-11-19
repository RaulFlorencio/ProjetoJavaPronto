package com.company.raul.repository;

import com.company.raul.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente,Integer> {

    public List<Cliente> findByNome (String nome);
    public List<Cliente> findByEmail(String email);
    public List<Cliente> findAll();
}
