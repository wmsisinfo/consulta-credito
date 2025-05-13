package br.com.eicon.consulta_creditos.services;

import br.com.eicon.consulta_creditos.dto.CreditoResponseDTO;
import br.com.eicon.consulta_creditos.entities.Credito;
import br.com.eicon.consulta_creditos.repositories.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository repository;

    public CreditoServiceImpl(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CreditoResponseDTO> buscarPorNfse(String numeroNfse) {
        List<Credito> entidades = repository.findByNumeroNfse(numeroNfse);
        return entidades.stream()
                .map(CreditoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditoResponseDTO> buscarPorCredito(String numeroCredito) {
        List<Credito> entidades = repository.findByNumeroCredito(numeroCredito);
        return entidades.stream()
                .map(CreditoResponseDTO::new)
                .collect(Collectors.toList());
    }
}