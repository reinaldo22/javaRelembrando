package com.crud.postgres.reinaldo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.postgres.reinaldo.model.UserA;

public interface UserRepository extends JpaRepository<UserA, Long> {

	@Query("SELECT us FROM UserA us where us.name = ?1")
	List<UserA> findUserByName(String name);
	
	@Query("SELECT us FROM UserA us where us.login = ?1")
	List<UserA> findUserByLogin(String login);

}
