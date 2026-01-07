package com.devfabiosimones.api.repository;

import com.devfabiosimones.api.entity.Endereco;
import com.devfabiosimones.api.projections.EnderecoDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(nativeQuery = true, value = """
				SELECT tb_endereco.cep AS cep
                FROM tb_endereco
				WHERE tb_endereco.cep = :cep
			""")
    List<EnderecoDetailsProjection> buscaCepNoBanco(String cep);
}
