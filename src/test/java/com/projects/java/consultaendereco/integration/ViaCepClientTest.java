package com.projects.java.consultaendereco.integration;

import com.projects.java.consultaendereco.domain.ViaCepResponse;
import com.projects.java.consultaendereco.mock.EnderecoViaCepMock;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ViaCepClientTest {

    @Autowired
    private ViaCepClient client;

    @Test
    public void deveBuscarInformacoesNaViaCepComSucesso(){
        String cep = "01001000";

        ViaCepResponse result = client.getEndereco(cep);

        ViaCepResponse expected = EnderecoViaCepMock.getEnderecoCep01001000();
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void deveRetornarAtributoErroIgualATrue(){
        String cep = "12345678";

        ViaCepResponse result = client.getEndereco(cep);

        ViaCepResponse expected = ViaCepResponse.builder().erro(true).build();
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void deveLancarFeignException(){
        String cep = "123456789";
        Assertions.assertThrows(FeignException.class,() ->
                client.getEndereco(cep));
    }

}
