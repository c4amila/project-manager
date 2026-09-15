package com.c4amila.ProjectManager.domain.repository;

import com.c4amila.ProjectManager.domain.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, String> {
}
