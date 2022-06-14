package com.example.desafioWL.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafioWL.controller.UserController;
import com.example.desafioWL.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private UserController controller;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = controller.listAll();
				
		return ResponseEntity.ok().body(list);
	}	
	
	@GetMapping(value = "/{id}")//pegando um id
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = controller.getUser(id);
	return ResponseEntity.ok().body(obj); //retorna um usuario especifico pelo id
	}
}
