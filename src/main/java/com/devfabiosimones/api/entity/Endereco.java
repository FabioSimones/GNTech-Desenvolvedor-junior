package com.devfabiosimones.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 9, nullable = false, unique = true)
    private String cep;

    @Column(length = 80)
    private String logradouro;

    @Column(length = 20)
    private String bairro;

    @Column(length = 20)
    private String localidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 3)
    private Integer ddd;
}
