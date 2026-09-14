package com.c4amila.ProjectManager.domain.service;

import com.c4amila.ProjectManager.domain.entity.Projeto;
import com.c4amila.ProjectManager.domain.model.StatusProjeto;
import com.c4amila.ProjectManager.domain.repository.ProjetoRepository;
import com.c4amila.ProjectManager.infrastructure.dto.ProjetoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Transactional
    public Projeto criarProjeto(ProjetoDTO projetoDTO){
        Projeto projeto = Projeto
                .builder()
                .nome(projetoDTO.getNome())
                .descricao(projetoDTO.getDescricao())
                .status(StatusProjeto.PENDENTE)
                .dataInicio(projetoDTO.getDataInicio())
                .dataFim(projetoDTO.getDataFim())
                .build();

        projetoRepository.save(projeto);

        return projeto;
    }
}
