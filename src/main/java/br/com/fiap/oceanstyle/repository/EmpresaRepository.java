package br.com.fiap.oceanstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.oceanstyle.model.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("from Empresa where LOWER(nome) like LOWER(CONCAT('%', :nome, '%'))")
    List<Empresa> buscarPorNome(@Param("nome") String nome);
}
