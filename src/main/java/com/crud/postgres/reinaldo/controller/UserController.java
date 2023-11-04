package com.crud.postgres.reinaldo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.postgres.reinaldo.model.UserA;
import com.crud.postgres.reinaldo.service.UserService;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

	@Autowired
	private UserService usuarioservice;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	private ResponseEntity<UserA> save(@RequestBody UserA usuar) {
		UserA salvar = usuarioservice.inserUser(usuar);

		return new ResponseEntity<UserA>(salvar, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private ResponseEntity<Page<UserA>> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String nome) {

		Pageable pageable = PageRequest.of(page, size, Sort.by("nome"));
		Page<UserA> pageResult = usuarioservice.getAll(pageable);

		return new ResponseEntity<Page<UserA>>(pageResult, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<Void> delete(@PathVariable Long id) {

		usuarioservice.delete(id);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	private ResponseEntity<Void> update(@RequestBody UserA usuar) {

		usuarioservice.updateUser(usuar);

		return ResponseEntity.noContent().build();
	}

}
