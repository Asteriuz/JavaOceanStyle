package br.com.fiap.oceanstyle.repository;

import br.com.fiap.oceanstyle.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findById(Long empresaId);

    @Query("from Endereco where cep = :cep")
    List<Endereco> buscarPorCep(String cep);
}
