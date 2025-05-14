package br.com.eicon.consulta_creditos.services;

import br.com.eicon.consulta_creditos.dto.ConsultaRealizadaEvent;
import br.com.eicon.consulta_creditos.dto.CreditoResponseDTO;
import br.com.eicon.consulta_creditos.entities.Credito;
import br.com.eicon.consulta_creditos.producer.KafkaProducerService;
import br.com.eicon.consulta_creditos.repositories.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository repository;
    private final KafkaProducerService kafkaProducerService;

    public CreditoServiceImpl(CreditoRepository repository, KafkaProducerService kafkaProducerService) {
        this.repository = repository;
        this.kafkaProducerService = kafkaProducerService;
    }

    private void EnviarLogKafka(String tipo, String documento, List<CreditoResponseDTO> resultado)
    {
        ConsultaRealizadaEvent evento = new ConsultaRealizadaEvent();
        evento.setTipoConsulta("NFS-e");
        evento.setValorConsultado(documento);
        evento.setTotalResultados(resultado.size());
        evento.setIpCliente("127.0.0.1");
        kafkaProducerService.enviarEvento("consultas-realizadas", evento);
    }

    @Override
    public List<CreditoResponseDTO> buscarPorNfse(String numeroNfse) {
        List<Credito> entidades = repository.findByNumeroNfse(numeroNfse);
        List<CreditoResponseDTO> resultado = entidades.stream()
                .map(CreditoResponseDTO::new)
                .collect(Collectors.toList());

        EnviarLogKafka("NFSE", numeroNfse, resultado);
        return resultado;
    }

    @Override
    public List<CreditoResponseDTO> buscarPorCredito(String numeroCredito) {
        List<Credito> entidades = repository.findByNumeroCredito(numeroCredito);
        List<CreditoResponseDTO> resultado = entidades.stream()
                .map(CreditoResponseDTO::new)
                .collect(Collectors.toList());
        EnviarLogKafka("Credito", numeroCredito, resultado);
        return resultado;
    }
}