package com.projects.java.consultaendereco.mock;

import com.projects.java.consultaendereco.domain.Endereco;

public class EnderecoMock {

    public static Endereco getEnderecoCep01001000(){
        return new Endereco("01001-000","Praça da Sé","lado ímpar","Sé","São Paulo","SP");
    }
}
