package com.crud.postgres.reinaldo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crud.postgres.reinaldo.exception.CustomException;
import com.crud.postgres.reinaldo.model.UserA;
import com.crud.postgres.reinaldo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public Page<UserA> getAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	public Optional<UserA> getUserById(Long id) {

		return userRepo.findById(id);
	}

	public UserA inserUser(UserA user) {
		List<UserA> nameExists = userRepo.findUserByName(user.getName());
		List<UserA> userExists = userRepo.findUserByLogin(user.getLogin());

		if ((userExists.size() != 0)|| (nameExists.size() != 0)) {
		    throw new CustomException("Nome ou e-mail já cadastrado", HttpStatus.CONFLICT);
		}
		
		return userRepo.save(user);
	}

	public UserA updateUser(UserA user) {
		
		if (user.getId_user() == null) {
			throw new CustomException("Usuário não encontrado", HttpStatus.NOT_FOUND);
		}
		
		UserA userExists = userRepo.findById(user.getId_user()).orElse(null);

		userExists.setName(user.getName());
		userExists.setLogin(user.getLogin());
		
		return userRepo.save(userExists);
	}

	public void delete(Long id) {

		Optional<UserA> userExists = userRepo.findById(id);

		if (userExists.isEmpty()) {
			throw new CustomException("Esse usuario nao foi encontrado", HttpStatus.BAD_REQUEST);
		}
		if (userExists.isPresent()) {
			userRepo.deleteById(id);
		}
		throw new CustomException("Deletado com sucesso", HttpStatus.ACCEPTED);
	}
}
