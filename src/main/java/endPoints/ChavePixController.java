package endPoints;
import entity.ChavePix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ChavePixService;

import java.util.Optional;

@RestController
@RequestMapping("/api/pix/chaves")
public class ChavePixController {

    @Autowired
    private ChavePixService chavePixService;

    @PostMapping("/api/pix/chaves/registrarChavePix")
    public ResponseEntity<ChavePix> registrarChavePix(@RequestBody ChavePix chavePix) {
        ChavePix novaChavePix = chavePixService.registrarChavePix(chavePix);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaChavePix);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChavePix> obterChavePixPorId(@PathVariable Long id) {
        Optional<ChavePix> chavePix = chavePixService.obterChavePixPorId(id);
        return chavePix.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChavePix> atualizarChavePix(@PathVariable Long id, @RequestBody ChavePix chavePix) {
        Optional<ChavePix> chavePixAtualizada = chavePixService.atualizarChavePix(id, chavePix);
        return chavePixAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerChavePix(@PathVariable Long id) {
        if (chavePixService.removerChavePix(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


