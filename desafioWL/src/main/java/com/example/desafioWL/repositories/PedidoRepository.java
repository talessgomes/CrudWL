package com.example.desafioWL.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.desafioWL.entities.Pedido;
import com.example.desafioWL.entities.pk.PedidoPK;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, PedidoPK> {

}
