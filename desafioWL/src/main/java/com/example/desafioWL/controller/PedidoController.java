package com.example.desafioWL.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.desafioWL.entities.Pedido;
import com.example.desafioWL.entities.pk.PedidoPK;
import com.example.desafioWL.repositories.PedidoRepository;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository repo;

	public PedidoController(PedidoRepository repo) {
		this.repo = repo;
	}

	//mapeamento da URL
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		model.addAttribute("listaPedidoes", repo.findAll());
		return "pedidos/index";
	}

	//cadastro de pedido
	@GetMapping("/pedidos/cadastrar")
	public String cadastrarPedido(@ModelAttribute("pedido") Pedido pedido) {
		return "pedidos/form";
	}

	//encontrar por ID
	@GetMapping("/pedidos/{id}")
	public String alterarPedido(@PathVariable("id") PedidoPK id, Model model) {
		Optional<Pedido> pedidoOpt = repo.findById(id);
		if (pedidoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pedido inválido.");
		}

		model.addAttribute("pedido", pedidoOpt.get());
		return "pedidos/form";
	}

	//salvar novo pedido
	@PostMapping("/pedidos/salvar")
	public String salvarPedido(@ModelAttribute("pedido") Pedido pedido) {
		repo.save(pedido);
		return "pedidos/form";
	}

	//remover pedido
	@GetMapping("/pedidos/remover/{id}")
	public String removerPedido(@PathVariable("id") PedidoPK id) {
		Optional<Pedido> pedidoOpt = repo.findById(id);
		if (pedidoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pedido inválidso.");
		}

		repo.delete(pedidoOpt.get());
		return "redirect:/pedidos";
	}
}
