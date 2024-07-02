package com.project.apirestfull.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.apirestfull.dto.EmpresaDto;
import com.project.apirestfull.models.EmpresaModel;


@Component
public class EmpresaMapper implements GenericMapper<EmpresaDto, EmpresaModel> {
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmpresaModel toEntity(EmpresaDto empresaDto) {
		return mapper.map(empresaDto,EmpresaModel.class);
	}

	@Override
	public EmpresaDto toDto(EmpresaModel empresa) {
		return mapper.map(empresa, EmpresaDto.class);
	}

}
