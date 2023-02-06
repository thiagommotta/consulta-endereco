package com.projects.java.consultaendereco.controller;

import com.projects.java.consultaendereco.domain.ConsultaEnderecoRequest;
import com.projects.java.consultaendereco.domain.Endereco;
import com.projects.java.consultaendereco.service.ConsultaEnderecoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta-endereco")
public class ConsultaEnderecoController {
    @Autowired
    private ConsultaEnderecoService consultaService;

    @ApiResponses(value = {
            @ApiResponse(responseCode= "200"),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cep não encontrado", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> getEndereco(@RequestBody ConsultaEnderecoRequest request) throws Exception {
        return ResponseEntity.ok(consultaService.buscaEnderecoByCep(request.getCep()));
    }
}
