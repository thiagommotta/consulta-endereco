package com.projects.java.consultaendereco.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
public enum Regiao {
    NORTE(new BigDecimal("20.83")),
    NORDESTE(new BigDecimal("15.98")),
    CENTRO_OESTE(new BigDecimal("12.50")),
    SUDESTE(new BigDecimal("7.85")),
    SUL(new BigDecimal("17.30"));

    @Getter
    private final BigDecimal valorFrete;
}
