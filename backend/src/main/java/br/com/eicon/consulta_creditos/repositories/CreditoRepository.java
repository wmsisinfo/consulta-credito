package br.com.eicon.consulta_creditos.repositories;

import br.com.eicon.consulta_creditos.entities.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditoRepository extends JpaRepository<Credito, Long> {
    List<Credito> findByNumeroNfse(String numeroNfse);
    List<Credito> findByNumeroCredito(String numeroCredito);
}
