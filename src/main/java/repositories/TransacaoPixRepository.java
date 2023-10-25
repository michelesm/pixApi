package repositories;

import entity.TransacaoPix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoPixRepository extends JpaRepository<TransacaoPix, Long> {

    // Inicia uma nova transação de pagamento PIX
    TransacaoPix savePagamento(TransacaoPix transacaoPix);

    // Inicia uma nova transação de transferência PIX
    TransacaoPix saveTransferencia(TransacaoPix transacaoPix);

    // Obtém os detalhes de uma transação PIX específica com o ID fornecido
    Optional<TransacaoPix> findById(Long id);

    // Obtém o histórico de transações PIX para um usuário específico com base no ID do usuário
    List<TransacaoPix> findByUsuarioId(Long usuarioId);

    // Obtém o status atual de uma transação PIX com o ID fornecido
    Optional<TransacaoPix> findByStatus(String status);
}
