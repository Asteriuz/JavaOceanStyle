package br.com.fiap.oceanstyle.repository;

import br.com.fiap.oceanstyle.model.Empresa;
import br.com.fiap.oceanstyle.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("from Veiculo where empresa = :empresa")
    List<Veiculo> buscarPorEmpresa(@Param("empresa") Empresa empresa);

    @Query("from Veiculo where empresa = :empresa and LOWER(nome) like LOWER(CONCAT('%', :nome, '%'))")
    List<Veiculo> buscarPorNomeEEmpresa(@Param("empresa") Empresa empresa, @Param("nome") String nome);

    @Query("from Veiculo where LOWER(nome) like LOWER(CONCAT('%', :nome, '%'))")
    List<Veiculo> buscarPorNome(@Param("nome") String nome);
}
