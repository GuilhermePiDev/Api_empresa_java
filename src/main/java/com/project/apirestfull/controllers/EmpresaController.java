package com.project.apirestfull.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfull.dto.EmpresaDto;
import com.project.apirestfull.models.EmpresaModel;
import com.project.apirestfull.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	public EmpresaService empresaService;
	
	
	@PostMapping
	public ResponseEntity<EmpresaDto> addEmpresa(@RequestBody EmpresaDto empresa) {
		 empresaService.addEmpresa(empresa);
		 return new ResponseEntity<>(empresa, HttpStatus.OK);
	}
	
	@GetMapping("/empresas")
	public List<EmpresaModel> getAllEmpresas(){
		return empresaService.returnEmpresas();
		
	}
	@GetMapping("{id}")
	public EmpresaModel getOne(@PathVariable("id") Integer id){
		return empresaService.returnOneEmpresa(id);
	}

}
