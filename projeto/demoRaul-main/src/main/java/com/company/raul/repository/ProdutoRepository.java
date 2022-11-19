package com.company.raul.repository;

import com.company.raul.model.Cliente;
import com.company.raul.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository <Produto,Integer> {
    public List <Produto> findByPreco (int preco);
    public List <Produto> findBycodigoProd (int codigoProd);
    public List<Produto> findByInf (String inf);
    public Optional<Produto> findByMarca(String marca);
    public List <Produto> findAll();
}
