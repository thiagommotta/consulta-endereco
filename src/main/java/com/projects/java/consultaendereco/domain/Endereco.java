package com.projects.java.consultaendereco.domain;

import com.projects.java.consultaendereco.enums.Estado;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private Estado estado;
    private BigDecimal frete;


    public Endereco(String cep, String rua, String complemento, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = Estado.valueOf(estado);
        this.frete = this.estado.getRegiao().getValorFrete();
    }
}
