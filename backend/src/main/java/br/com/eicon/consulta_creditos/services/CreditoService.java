package br.com.eicon.consulta_creditos.services;

import br.com.eicon.consulta_creditos.dto.CreditoResponseDTO;

import java.util.List;

public interface CreditoService {
    List<CreditoResponseDTO> buscarPorNfse(String numeroNfse);
    List<CreditoResponseDTO> buscarPorCredito(String numeroCredito);
}