package com.projects.java.consultaendereco.mock;

import com.projects.java.consultaendereco.domain.ViaCepResponse;

public class EnderecoViaCepMock {

    public static ViaCepResponse getEnderecoCep01001000(){
        return ViaCepResponse.builder()
                .cep("01001-000")
                .logradouro("Praça da Sé")
                .complemento("lado ímpar")
                .bairro("Sé")
                .localidade("São Paulo")
                .uf("SP")
                .ibge("3550308")
                .gia("1004")
                .ddd("11")
                .siafi("7107")
                .build();
    }
}
