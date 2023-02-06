package com.projects.java.consultaendereco.controller;

import com.projects.java.consultaendereco.domain.ConsultaEnderecoRequest;
import com.projects.java.consultaendereco.domain.Endereco;
import com.projects.java.consultaendereco.exception.CepNotFoundException;
import com.projects.java.consultaendereco.mock.EnderecoMock;
import com.projects.java.consultaendereco.service.ConsultaEnderecoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@ExtendWith(MockitoExtension.class)
public class ConsultaEnderecoControllerTest {
    @InjectMocks
    private ConsultaEnderecoController controller;
    @Mock
    private ConsultaEnderecoService service;

    @Test
    public void deveRetornarCodigo200ComDadosDoEndereco() throws Exception {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(service.buscaEnderecoByCep("01001000")).thenReturn(EnderecoMock.getEnderecoCep01001000());

        ResponseEntity<Endereco> responseEntity = controller.getEndereco(new ConsultaEnderecoRequest("01001000"));

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(EnderecoMock.getEnderecoCep01001000(),responseEntity.getBody());
    }

    @Test
    public void deveLancarCepNotFoundException() throws Exception {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(service.buscaEnderecoByCep("12345678")).thenThrow(new CepNotFoundException("Cep não encontrado"));

        Assertions.assertThrows(CepNotFoundException.class,() ->
                controller.getEndereco(new ConsultaEnderecoRequest("12345678")));
    }

}
