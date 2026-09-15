package com.c4amila.ProjectManager.infrastructure.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> handleRequestException(RequestException e, WebRequest request){
        return handleException(e,
                e.getErroCodigo(),
                e.getMessage(),
                null,
                BAD_REQUEST,
                request
        );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request){
        return handleException(e,
                null,
                e.getMessage(),
                null,
                INTERNAL_SERVER_ERROR,
                request
        );
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders header,
            HttpStatusCode status,
            WebRequest request) {

        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .filter(Objects::nonNull)
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return handleException(ex, "ValidationError", null, details, BAD_REQUEST, request);
    }

    private ResponseEntity<Object> handleException(Exception e,
                                                   String erroCodigo,
                                                   String mensagem,
                                                   List<String> details,
                                                   HttpStatus status,
                                                   WebRequest request){
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        return handleExceptionInternal(
                e,
                ErrorResponse
                        .builder()
                        .erroCodigo(erroCodigo)
                        .erroMensagem(mensagem)
                        .details(details)
                        .status(status.value())
                        .path(servletWebRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(),
                status,
                request
        );
    }

}
