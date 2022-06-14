package com.example.desafioWL.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.desafioWL.entities.Item;
//aqui é salvo os dados do banco 

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
