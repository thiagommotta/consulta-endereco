package com.projects.java.consultaendereco.integration;

import com.projects.java.consultaendereco.domain.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepResponse getEndereco(@PathVariable String cep);
}
