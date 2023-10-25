package services;
import entity.ChavePix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ChavePixRepository;

import java.util.Optional;

@Service
public class ChavePixService {

    @Autowired
    private ChavePixRepository chavePixRepository;

    public ChavePix registrarChavePix(ChavePix chavePix) {
        // Implemente a lógica de validação e regras de negócios necessárias
        // Por exemplo, verifique se a chave é única e se pertence ao usuário apropriado.
        // Antes de salvar a chave no repositório
        return chavePixRepository.save(chavePix);
    }

    public Optional<ChavePix> obterChavePixPorId(Long id) {
        return chavePixRepository.findById(id);
    }

    public Optional<ChavePix> atualizarChavePix(Long id, ChavePix chavePix) {
        // Implemente a lógica para atualizar os detalhes da chave no repositório
        // Certifique-se de validar as alterações permitidas, como a propriedade "tipo".
        Optional<ChavePix> chaveExistente = chavePixRepository.findById(id);

        if (chaveExistente.isPresent()) {
            ChavePix chaveAtualizada = chaveExistente.get();
            chaveAtualizada.setChave(chavePix.getChave());
            chaveAtualizada.setTipo(chavePix.getTipo());
            // Atualize outros atributos conforme necessário
            return Optional.of(chavePixRepository.save(chaveAtualizada));
        } else {
            return Optional.empty();
        }
    }

    public boolean removerChavePix(Long id) {
        // Implemente a lógica para remover a chave no repositório
        // Verifique se a chave existe antes de excluir.
        Optional<ChavePix> chaveExistente = chavePixRepository.findById(id);

        if (chaveExistente.isPresent()) {
            chavePixRepository.delete(chaveExistente.get());
            return true;
        } else {
            return false;
        }
    }
}
