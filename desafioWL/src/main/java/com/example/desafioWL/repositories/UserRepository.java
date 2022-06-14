package com.example.desafioWL.repositories;

import java.util.List;
//aqui é salvo os dados do banco 

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.desafioWL.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Transactional //inseri o valor
	@Query(value = "INSERT INTO TB_USER (NOME, CPF, ITEM) VALUES (?)", nativeQuery = true)
	User insert(User  user);
	

	@Query("SELECT c FROM User c WHERE c.cpf = :cpf") //verifica o cpf
	public User findByCpf(@PathParam("cpf") String cpf); 
	
	@Query("SELECT c FROM User c WHERE c.cpf = :cpf")
    public User findByCPF(@Param("cpf") String cpf);

	@Query(value = "SELECT * FROM TB_USER ORDER BY ID", nativeQuery = true)
	List<User> findAll();

	@Query(value = "SELECT * FROM TB_USER u WHERE u.ID = ?", nativeQuery = true)
	User getUser(Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE TB_USER SET NOME = ?2, CPF = ?3 WHERE ID = ?1", nativeQuery = true)
	User update(Long id, User obj);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM TB_USER WHERE ID = ?", nativeQuery = true)
	void delete(Long id);

}
