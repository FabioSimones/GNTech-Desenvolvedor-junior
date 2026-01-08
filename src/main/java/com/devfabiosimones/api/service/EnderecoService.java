package com.devfabiosimones.api.service;

import com.devfabiosimones.api.config.ViaCepConfig;
import com.devfabiosimones.api.entity.Endereco;
import com.devfabiosimones.api.entity.dto.EnderecoDTO;
import com.devfabiosimones.api.projections.EnderecoDetailsProjection;
import com.devfabiosimones.api.repository.EnderecoRepository;
import com.devfabiosimones.api.service.exceptions.NotFoundException;
import com.devfabiosimones.api.service.exceptions.ResourceAlreadyExistsException;
import com.devfabiosimones.api.service.exceptions.ResourceNotFoundException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final ViaCepConfig viaCepConfig;
    private EnderecoRepository repository;


    public Endereco buscarSalvarEndereco(String cep) {
        buscaCepBanco(cep);
        EnderecoDTO dto = consultaCepExterno(cep);
        Endereco endereco = salvaBanco(dto);

        return repository.save(endereco);
    }

    public List<Endereco> buscarEndereco() {
        return repository.findAll();
    }

    private static Endereco salvaBanco(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setCep(dto.getCep().replaceAll("\\D", ""));
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setBairro(dto.getBairro());
        endereco.setLocalidade(dto.getLocalidade());
        endereco.setUf(dto.getUf());
        endereco.setDdd(dto.getDdd());
        return endereco;
    }

    private EnderecoDTO consultaCepExterno(String cep) {
        try {
            if (cep == null || cep.isBlank()) {
                throw new NotFoundException("CEP inválido ou não informado");
            }
            return viaCepConfig.consultarCep(cep);

        } catch (FeignException e) {
            if (e.status() == 400 || e.status() == 404) {
                throw new ResourceNotFoundException("CEP inválido ou não encontrado: " + cep);
            }

            throw new RuntimeException("Erro ao consultar ViaCEP: " + e.getMessage(), e);
        }
    }

    private void buscaCepBanco(String cep) {
        List<EnderecoDetailsProjection> existeBanco = repository.buscaCepNoBanco(cep);
        if (!existeBanco.isEmpty()) {
            throw new ResourceAlreadyExistsException("CEP já existe no banco de dados: " + cep);
        }
    }
}
