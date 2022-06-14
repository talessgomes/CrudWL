package com.example.desafioWL.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.desafioWL.entities.Item;
import com.example.desafioWL.repositories.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	private ItemRepository rep;

	public ItemController(ItemRepository rep) {
		this.rep = rep;
	}
	
	public List<Item> listAll(){
		return (List<Item>) this.rep.findAll();
	}
	
	public void salvar(@ModelAttribute("item") Item item) {
		this.rep.save(item);
	}
	
	public Item getItem(Long id) {
		return this.rep.findById(id).get();
	}
	
	public void delete(Long id) {
		this.rep.deleteById(id);
	}

	//mapeamento da URL
	@GetMapping("/itens")
	public String itens(Model model) {
		model.addAttribute("listaItens", rep.findAll());
		return "users/index";
	}

	//cadastro de lanche
	@GetMapping("/itens/cadastrar")
	public String cadastrarItem(@ModelAttribute("item") Item item) {
		return "users/form";
	}

	//encontrar por ID
	@GetMapping("/itens/{id}")
	public String alterarItem(@PathVariable("id") long id, Model model) {
		Optional<Item> itemOpt = rep.findById(id);
		if (itemOpt.isEmpty()) {
			throw new IllegalArgumentException("Item inválido.");
		}

		model.addAttribute("item", itemOpt.get());
		return "users/form";
	}

	//salvar novo lanche
	@PostMapping("/itens/salvar")
	public String salvarItem(@ModelAttribute("lanche") Item item) {
		rep.save(item);
		return "users/form";
	}

	//remover lanche
	@GetMapping("/itens/remover/{id}")
	public String removerItem(@PathVariable("id") long id) {
		Optional<Item> itemOpt = rep.findById(id);
		if (itemOpt.isEmpty()) {
			throw new IllegalArgumentException("Item inválido.");
		}

		rep.delete(itemOpt.get());
		return "redirect:/itens";
	}
}

