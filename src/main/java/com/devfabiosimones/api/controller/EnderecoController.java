package com.devfabiosimones.api.controller;

import com.devfabiosimones.api.entity.Endereco;
import com.devfabiosimones.api.entity.dto.EnderecoDTO;
import com.devfabiosimones.api.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService service;

    @Transactional
    @PostMapping("/{cep}")
    public ResponseEntity<Endereco> salvarEndereco(@PathVariable String cep) {
        Endereco endereco = service.buscarSalvarEndereco(cep);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}")
                .buildAndExpand(endereco.getCep()).toUri();

        return ResponseEntity.created(uri).body(endereco);
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
        List<EnderecoDTO> dto = service.buscarEndereco().stream()
                .map(EnderecoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}
