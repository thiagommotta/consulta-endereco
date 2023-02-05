package com.projects.java.consultaendereco.controller;

import com.projects.java.consultaendereco.domain.ConsultaEnderecoRequest;
import com.projects.java.consultaendereco.domain.Endereco;
import com.projects.java.consultaendereco.service.ConsultaEnderecoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consulta-endereco")
public class ConsultaEnderecoController {
    private final ConsultaEnderecoService consultaService;

    public ConsultaEnderecoController(ConsultaEnderecoService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Endereco getEndereco(@RequestBody ConsultaEnderecoRequest request) throws Exception {
        return consultaService.buscaEnderecoByCep(request.getCep());
    }
}
