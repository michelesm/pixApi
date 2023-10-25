package services;

import entity.TransacaoPix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TransacaoPixRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoPixService {

    @Autowired
    private TransacaoPixRepository transacaoPixRepository;

    public TransacaoPix iniciarTransacaoPagamento(TransacaoPix transacaoPix) {
        // Implemente a lógica de validação e regras de negócios necessárias
        // Antes de salvar a transação no repositório
        return transacaoPixRepository.save(transacaoPix);
    }

    public TransacaoPix iniciarTransacaoTransferencia(TransacaoPix transacaoPix) {
        // Implemente a lógica de validação e regras de negócios necessárias
        // Antes de salvar a transação no repositório
        return transacaoPixRepository.save(transacaoPix);
    }

    public Optional<TransacaoPix> obterTransacaoPixPorId(Long id) {
        return transacaoPixRepository.findById(id);
    }

    public List<TransacaoPix> obterHistoricoTransacoesPorUsuario(Long usuarioId) {
        // Implemente a lógica para buscar o histórico de transações com base no ID do usuário
        // por exemplo: transacaoPixRepository.findByUsuarioId(usuarioId);
        return Collections.emptyList(); // Retorne a lista de transações
    }

    public Optional<TransacaoPix> obterStatusTransacaoPix(Long id) {
        return transacaoPixRepository.findById(id);
    }
}
