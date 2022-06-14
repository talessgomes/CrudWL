/*
package com.example.desafioWL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.desafioWL.entities.User;
import com.example.desafioWL.repositories.UserRepository;

@Service //registrando um serviço como componente do spring
public class UserService {

	@Autowired //usado para fazer uma injeção de informação
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
*/