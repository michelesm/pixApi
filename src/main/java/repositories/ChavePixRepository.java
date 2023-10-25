package repositories;
import entity.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, Long> {
    ChavePix findByChave(String chave);

    // Registrar uma nova chave PIX
    ChavePix save(ChavePix chavePix);

    // Obter detalhes de uma chave PIX específica por ID
    ChavePix buscaPorId(Long id);

    // Atualizar os detalhes de uma chave PIX específica por ID
    @Modifying
    @Query("UPDATE ChavePix c SET c.chave = :chave, c.tipo = :tipo WHERE c.id = :id")
    @Transactional
    void updateChavePix(Long id, String chave, String tipo);

    // Remover uma chave PIX específica por ID
    void deleteById(Long id);
}
