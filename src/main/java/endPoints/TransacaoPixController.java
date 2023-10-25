package endPoints;

import entity.TransacaoPix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TransacaoPixService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pix/transacoes")
public class TransacaoPixController {

    @Autowired
    private TransacaoPixService transacaoPixService;

    @PostMapping("/pagamento")
    public ResponseEntity<TransacaoPix> iniciarTransacaoPagamento(@RequestBody TransacaoPix transacaoPix) {
        TransacaoPix novaTransacao = transacaoPixService.iniciarTransacaoPagamento(transacaoPix);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransacaoPix> iniciarTransacaoTransferencia(@RequestBody TransacaoPix transacaoPix) {
        TransacaoPix novaTransacao = transacaoPixService.iniciarTransacaoTransferencia(transacaoPix);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoPix> obterTransacaoPixPorId(@PathVariable Long id) {
        Optional<TransacaoPix> transacaoPix = transacaoPixService.obterTransacaoPixPorId(id);
        return transacaoPix.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/historico/{usuarioId}")
    public ResponseEntity<List<TransacaoPix>> obterHistoricoTransacoesPorUsuario(@PathVariable Long usuarioId) {
        List<TransacaoPix> historicoTransacoes = transacaoPixService.obterHistoricoTransacoesPorUsuario(usuarioId);
        return ResponseEntity.ok(historicoTransacoes);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<TransacaoPix> obterStatusTransacaoPix(@PathVariable Long id) {
        Optional<TransacaoPix> transacaoPix = transacaoPixService.obterTransacaoPixPorId(id);
        return transacaoPix.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
