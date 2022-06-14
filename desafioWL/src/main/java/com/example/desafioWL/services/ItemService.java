/*
package com.example.desafioWL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafioWL.entities.Item;
import com.example.desafioWL.repositories.ItemRepository;

@Service //registrando um serviço como componente do spring
public class ItemService {

	@Autowired //usado para fazer uma injeção de informação
	private ItemRepository repository;
	
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		return obj.get();
	}
}
*/