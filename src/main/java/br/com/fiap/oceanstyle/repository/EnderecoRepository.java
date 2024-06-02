package br.com.fiap.oceanstyle.repository;

import br.com.fiap.oceanstyle.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
