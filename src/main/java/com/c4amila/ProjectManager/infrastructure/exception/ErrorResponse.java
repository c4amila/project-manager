package com.c4amila.ProjectManager.infrastructure.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {
    private final String erroCodigo;
    private final String erroMensagem;
    private final List<String> details;
    private final int status;
    private final String path;

}
