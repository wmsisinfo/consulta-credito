package br.com.eicon.consulta_creditos.resources;

import br.com.eicon.consulta_creditos.dto.CreditoResponseDTO;
import br.com.eicon.consulta_creditos.exception.ResourceNotFoundException;
import br.com.eicon.consulta_creditos.services.CreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService service;

    public CreditoController(CreditoService service) {
        this.service = service;
    }

    /**
     * Busca créditos por número da NFS-e.
     * Exemplo: GET /api/creditos/7891011
     */
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDTO>> porNfse(@PathVariable String numeroNfse) {
        List<CreditoResponseDTO> lista = service.buscarPorNfse(numeroNfse);
        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum crédito encontrado para a NFS-e: " + numeroNfse);
        }
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca créditos por número do crédito.
     * Exemplo: GET /api/creditos/credito/123456
     */
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<List<CreditoResponseDTO>> porCredito(@PathVariable String numeroCredito) {
        List<CreditoResponseDTO> lista = service.buscarPorCredito(numeroCredito);
        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum crédito encontrado para: " + numeroCredito);
        }
        return ResponseEntity.ok(lista);
    }
}
