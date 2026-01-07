package com.devfabiosimones.api.entity.dto;

import com.devfabiosimones.api.entity.Endereco;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ddd;

    public EnderecoDTO(Endereco entity) {
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
        ddd = entity.getDdd();


    }
}
