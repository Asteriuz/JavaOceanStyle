package br.com.fiap.oceanstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.oceanstyle.model.Vistoria;

import java.util.List;

public interface VistoriaRepository extends JpaRepository<Vistoria, Long> {

    @Query("from Vistoria where nivelRuido >= :nivelRuidoMin and nivelRuido <= :nivelRuidoMax")
    List<Vistoria> buscarPorNivelRuidoRange(@Param("nivelRuidoMin") Integer nivelRuidoMin,
            @Param("nivelRuidoMax") Integer nivelRuidoMax);

    @Query("from Vistoria where nivelRuido >= :nivelRuidoMin")
    List<Vistoria> buscarPorNivelRuidoMin(@Param("nivelRuidoMin") Integer nivelRuidoMin);

    @Query("from Vistoria where nivelRuido <= :nivelRuidoMax")
    List<Vistoria> buscarPorNivelRuidoMax(@Param("nivelRuidoMax") Integer nivelRuidoMax);
}
