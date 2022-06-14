/*
package com.example.desafioWL.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.desafioWL.entities.Item;
import com.example.desafioWL.entities.User;
import com.example.desafioWL.repositories.ItemRepository;
import com.example.desafioWL.repositories.UserRepository;

@Configuration
@Profile("test")//aqui vai ser passado o perfil test
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemrepository;

	@Override
	public void run(String... args) throws Exception {
		
		Item i1 = new Item(null, "Pão");
		Item i2 = new Item(null, "Café");
		
		User u1 = new User(null, "Maria Brown", "4567891388", i1);
		User u2 = new User(null, "Carlos Brown", "516518946", i2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));//salvar no banco
		itemrepository.saveAll(Arrays.asList(i1, i2));
	}
	
	
}
*/
