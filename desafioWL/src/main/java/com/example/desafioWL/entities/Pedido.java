package com.example.desafioWL.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.desafioWL.entities.pk.PedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@EmbeddedId
	private PedidoPK id = new PedidoPK();

	public Pedido() {
		
	}
	
	public Pedido(User user, Item item) {
		super();
		id.setUser(user);
		id.setItem(item);
	}
	
	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}
	
	public Item getItem() {
		return id.getItem();
	}
	
	public void setItem(Item item) {
		id.setItem(item);
	}
}