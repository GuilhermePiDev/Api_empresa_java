package com.project.apirestfull.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.apirestfull.models.EmpresaModel;

public interface EmpresaRepo extends JpaRepository<EmpresaModel, Integer> {
}
