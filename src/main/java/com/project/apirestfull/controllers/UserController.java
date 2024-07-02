package com.project.apirestfull.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfull.mapper.UserMapper;
import com.project.apirestfull.models.EmpresaModel;
import com.project.apirestfull.models.UserModel;
import com.project.apirestfull.services.EmpresaService;

import com.project.apirestfull.services.UserService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UserMapper usermapper;
	
	


	@GetMapping("users")
	public List<UserModel> returnBd() {
		return userService.returnUsers();

	}

	@PostMapping
	public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user) {
	    EmpresaModel empresa = empresaService.empresaAddInUser(user);
	    user.setEmpresa(empresa);
	    userService.createUser(user);
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> UserId(@PathVariable("id") Integer id) {
		try {
			UserModel user  = userService.returnOneUser(id);

			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (EntityNotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteUserbyId(@PathVariable("id") Integer id) {
		try {
			UserModel user  = userService.returnOneUser(id);
			userService.deleteUser(id);
			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (EntityNotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	@PutMapping("{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id, @RequestBody UserModel user) {
		try {
			UserModel userGravado  = userService.returnOneUser(id);
			
			userGravado.setNome(user.getNome());
			userGravado.setEmail(user.getEmail());
			userGravado.setTelefone(user.getTelefone());
			userService.createUser(userGravado);

			return new ResponseEntity<>(userGravado, HttpStatus.OK);
		} catch (EntityNotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	
	
}
