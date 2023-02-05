package com.projects.java.consultaendereco.service;

import com.projects.java.consultaendereco.domain.Endereco;
import com.projects.java.consultaendereco.domain.ViaCepResponse;
import com.projects.java.consultaendereco.exception.CepNotFoundException;
import com.projects.java.consultaendereco.integration.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class ConsultaEnderecoService {
    private final ViaCepClient client;

    public ConsultaEnderecoService(ViaCepClient client) {
        this.client = client;
    }

    public Endereco buscaEnderecoByCep(String cep) throws Exception {

        ViaCepResponse response = this.client.getEndereco(cep);

        if(response.isErro()) throw new CepNotFoundException("Cep não encontrado");

        Endereco endereco = new Endereco(
                response.getCep(),
                response.getLogradouro(),
                response.getComplemento(),
                response.getBairro(),
                response.getLocalidade(),
                response.getUf()
        );

        return endereco;
    }

}
