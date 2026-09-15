package com.c4amila.ProjectManager.infrastructure.exception;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException{

    private final String erroCodigo;

    public RequestException(String message, String erroCodigo) {
        super(message);
        this.erroCodigo = erroCodigo;
    }
}
