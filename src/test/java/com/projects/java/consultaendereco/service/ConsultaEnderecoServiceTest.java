package com.projects.java.consultaendereco.service;

import com.projects.java.consultaendereco.domain.Endereco;
import com.projects.java.consultaendereco.enums.Estado;
import com.projects.java.consultaendereco.exception.CepNotFoundException;
import com.projects.java.consultaendereco.mock.EnderecoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsultaEnderecoServiceTest {
    @Autowired
    private ConsultaEnderecoService service;

    @Test
    public void deveRetornarEnderecoComFrete() throws Exception {
        String cep = "01001000";

        Endereco result = service.buscaEnderecoByCep(cep);

        Endereco expected = EnderecoMock.getEnderecoCep01001000();
        Assertions.assertEquals(result,expected);
        Assertions.assertEquals(result.getFrete(),Estado.SP.getRegiao().getValorFrete());
    }

    @Test
    void deveLancarCepNaoEncontradoException(){
        String cep = "12345678";

        Exception ex = Assertions.assertThrows(CepNotFoundException.class, ()-> service.buscaEnderecoByCep(cep));

        String expectedMessage = "Cep não encontrado";
        String resultMessage = ex.getMessage();

        Assertions.assertEquals(expectedMessage,resultMessage);
    }
}
