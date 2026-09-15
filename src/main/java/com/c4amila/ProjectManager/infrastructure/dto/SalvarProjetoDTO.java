package com.c4amila.ProjectManager.infrastructure.dto;

import com.c4amila.ProjectManager.domain.model.StatusProjeto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalvarProjetoDTO {
    private final String nome;
    private final String descricao;
    private final StatusProjeto status;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
}
