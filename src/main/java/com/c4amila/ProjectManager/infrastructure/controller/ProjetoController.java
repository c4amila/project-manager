package com.c4amila.ProjectManager.infrastructure.controller;

import com.c4amila.ProjectManager.domain.entity.Projeto;
import com.c4amila.ProjectManager.domain.service.ProjetoService;
import com.c4amila.ProjectManager.infrastructure.dto.ProjetoResponseDTO;
import com.c4amila.ProjectManager.infrastructure.dto.SalvarProjetoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.c4amila.ProjectManager.infrastructure.controller.RestConstants.PATH_PROJETOS;

@RestController
@RequestMapping(PATH_PROJETOS)
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping("/criar-projeto")
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody SalvarProjetoDTO salvarProjetoDTO){
        Projeto projeto = projetoService.criarProjeto(salvarProjetoDTO);
        return ResponseEntity.created(URI.create(PATH_PROJETOS + "/" + projeto.getId()))
                .body(ProjetoResponseDTO.criar(projeto));
    }
}
