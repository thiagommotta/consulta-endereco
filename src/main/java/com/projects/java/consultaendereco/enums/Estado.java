package com.projects.java.consultaendereco.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum Estado {
    AC(Regiao.NORTE),
    AL(Regiao.NORDESTE),
    AP(Regiao.NORTE),
    AM(Regiao.NORTE),
    BA(Regiao.NORDESTE),
    CE(Regiao.NORDESTE),
    DF(Regiao.CENTRO_OESTE),
    ES(Regiao.SUDESTE),
    GO(Regiao.CENTRO_OESTE),
    MA(Regiao.NORDESTE),
    MT(Regiao.CENTRO_OESTE),
    MS(Regiao.CENTRO_OESTE),
    MG(Regiao.SUDESTE),
    PA(Regiao.NORTE),
    PB(Regiao.NORDESTE),
    PR(Regiao.SUL),
    PE(Regiao.NORDESTE),
    PI(Regiao.NORDESTE),
    RJ(Regiao.SUDESTE),
    RN(Regiao.NORDESTE),
    RS(Regiao.SUL),
    RO(Regiao.NORTE),
    RR(Regiao.NORTE),
    SC(Regiao.SUL),
    SP(Regiao.SUDESTE),
    SE(Regiao.NORDESTE),
    TO(Regiao.NORTE);

    @Getter
    private final Regiao regiao;


}
