package com.project.apirestfull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apirestfull.dto.UserDto;
import com.project.apirestfull.models.UserModel;
import com.project.apirestfull.repositorys.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepo userrepo;
	// teste

	public void createUser(UserModel user) {
		userrepo.save(user);
	}

	

	// retorna todos usuarios da table usuario
	public List<UserModel> returnUsers() {

		if (userrepo != null) {
			return userrepo.findAll();
		} else {
			return null;
		}
	}

	// retorna apenas 1 user (por id)
	public UserModel returnOneUser(Integer id) {

		existUser(id);
		return userrepo.findById(id).orElse(null);

	}

	public void deleteUser(Integer id) {
		existUser(id);
		userrepo.deleteById(id);

	}

	// metodo para retornar se o id existe ou nao
	private void existUser(Integer id) {
		if (!userrepo.existsById(id)) {

			// aqui estou instanciando um novo "EntityNotFoundException" é usado para
			// indicar que algo não foi encontrado no bd
			throw new EntityNotFoundException("Usuario com o id: *" + id + "* não encontrado");
			// uma execption é usada para lidar com situações anormais(erros e situações de
			// maneira controlada)
		}
	}

}
