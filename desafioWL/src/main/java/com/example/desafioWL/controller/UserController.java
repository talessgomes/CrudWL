
package com.example.desafioWL.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.example.desafioWL.entities.Item;
import com.example.desafioWL.entities.User;
import com.example.desafioWL.entities.exception.ItemException;
import com.example.desafioWL.entities.exception.ResourceNotFoundException;
import com.example.desafioWL.repositories.ItemRepository;
import com.example.desafioWL.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository rep;
	
	@Autowired
	private ItemRepository repItem;
	

	public List<User> listAll() {
		return (List<User>) this.rep.findAll(); // retorna uma lista de usuários
	}

	public User getUser(Long id) {
		return this.rep.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void salvar(User user) {
		this.rep.save(user);
	}

	public void delete(Long id) {
		this.rep.deleteById(id);
	}

	public UserController(UserRepository rep) {
		this.rep = rep;
	}

	// faz o Map
	@GetMapping("/users")
	public String colaboradores(Model model) {
		model.addAttribute("listUsers", rep.findAll());
		return "index";
	}

	// Cadastrar usuário
	@GetMapping("/users/cadastrar")
	public String cadastrarColaborador(@ModelAttribute("user") User user) {
		return "users/form";
	}

	// procura o id
	@GetMapping("/users/{id}")
	public String alterarUser(@PathVariable("id") long id, Model model) {
		Optional<User> userOpt = rep.findById(id);
		if (userOpt.isEmpty()) {
			throw new IllegalArgumentException("Usuário inválido.");
		}

		model.addAttribute("user", userOpt.get());
		return "users/form";
	}
	


	// salvar usuário  			findByCpf
		@PostMapping("users/salvar")
		public ModelAndView insert(@Valid User user, BindingResult bindingResult) {
	        if(bindingResult.hasErrors()) {
	        }  else 
	        {{ if (rep.findByCPF(user.getCpf()) == null){
	                  ModelAndView mv = new ModelAndView("redirect:/users");
	                  rep.save(user);

	              mv.addObject("mensagem", "User " + user.getNome() + " inserido com sucesso.");
	              return mv;
	        } else {
	            ModelAndView mv = new ModelAndView("redirect:/users");
	            mv.addObject("mensagem", "Erro: este cpf já existe.");
	            return mv;

	        }
	    }
	        }
	        return null;
	        

	    }

	// deletando usuário
	@GetMapping("/users/remover/{id}")
	public String removerUser(@PathVariable("id") long id) {
		Optional<User> userOpt = rep.findById(id);
		if (userOpt.isEmpty()) {
			throw new IllegalArgumentException("Usuário inválido.");
		}

		rep.delete(userOpt.get());
		return "redirect:/users";
	}
}