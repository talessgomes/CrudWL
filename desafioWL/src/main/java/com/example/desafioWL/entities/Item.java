package com.example.desafioWL.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String item;

	@JsonIgnore
	@OneToMany(mappedBy = "item")
	private List<User> users = new ArrayList<>();

	public Item() {

	}

	public Item(Long id, String item) {
		super();
		this.id = id;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item);
	}

}
