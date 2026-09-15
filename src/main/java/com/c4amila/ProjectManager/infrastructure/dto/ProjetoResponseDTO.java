package com.c4amila.ProjectManager.infrastructure.dto;

import com.c4amila.ProjectManager.domain.entity.Projeto;
import com.c4amila.ProjectManager.domain.model.StatusProjeto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoResponseDTO {
    private final String id;
    private final String nome;
    private final String descricao;
    private final StatusProjeto status;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;

    public static ProjetoResponseDTO criar(Projeto projeto){
        return new ProjetoResponseDTO(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getStatus(),
                projeto.getDataInicio(),
                projeto.getDataFim()
        );
    }
}
