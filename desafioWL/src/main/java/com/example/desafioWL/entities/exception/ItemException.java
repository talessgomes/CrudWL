package com.example.desafioWL.entities.exception;

public class ItemException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ItemException() {
		super("Item in use by another user");
	}
}
