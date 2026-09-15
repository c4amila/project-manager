package com.c4amila.ProjectManager.infrastructure.dto;

import com.c4amila.ProjectManager.domain.model.StatusProjeto;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalvarProjetoDTO {

    @NotNull(message = "O nome deve ser obrigatório")
    @Size(min = 1, max = 80)
    private final String nome;

    @NotNull(message = "A descrição é obrigatória")
    @Size(min = 1, max = 150)
    private final String descricao;

    private final StatusProjeto status;

    @NotNull(message = "A data de início não pode ser vazia")
    private final LocalDate dataInicio;

    @NotNull(message = "A data final não pode ser vazia")
    private final LocalDate dataFim;

    @AssertTrue(message = "As datas não são consistentes")
    private boolean isInitialDateBeforeFinalDate(){
        return dataInicio.isBefore(dataFim);
    }
}
