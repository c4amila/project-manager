package com.c4amila.ProjectManager.domain.service;

import com.c4amila.ProjectManager.domain.entity.Projeto;
import com.c4amila.ProjectManager.domain.model.StatusProjeto;
import com.c4amila.ProjectManager.domain.repository.ProjetoRepository;
import com.c4amila.ProjectManager.infrastructure.dto.SalvarProjetoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Transactional
    public Projeto criarProjeto(SalvarProjetoDTO salvarProjetoDTO){
        Projeto projeto = Projeto
                .builder()
                .nome(salvarProjetoDTO.getNome())
                .descricao(salvarProjetoDTO.getDescricao())
                .status(StatusProjeto.PENDENTE)
                .dataInicio(salvarProjetoDTO.getDataInicio())
                .dataFim(salvarProjetoDTO.getDataFim())
                .build();

        projetoRepository.save(projeto);

        return projeto;
    }
}
