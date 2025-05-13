package br.com.eicon.consulta_creditos;


import br.com.eicon.consulta_creditos.dto.CreditoResponseDTO;
import br.com.eicon.consulta_creditos.resources.CreditoController;
import br.com.eicon.consulta_creditos.services.CreditoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CreditoController.class)
class CreditoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService service;

    private CreditoResponseDTO makeDto() {
        return new CreditoResponseDTO(
                /* construtor modificado para este teste: */
                new br.com.eicon.consulta_creditos.entities.Credito(
                        null,
                        "123456",
                        "7891011",
                        LocalDate.of(2024, 2, 25),
                        BigDecimal.valueOf(1500.75),
                        "ISSQN",
                        true,
                        BigDecimal.valueOf(5.0),
                        BigDecimal.valueOf(30000.00),
                        BigDecimal.valueOf(5000.00),
                        BigDecimal.valueOf(25000.00)
                )
        );
    }

    @Test
    @DisplayName("GET /api/creditos/{nfse} retorna 200 e JSON correto")
    void porNfse_Sucesso() throws Exception {
        var dto = makeDto();
        when(service.buscarPorNfse("7891011")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/creditos/{nfse}", "7891011")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].numeroCredito").value("123456"))
                .andExpect(jsonPath("$[0].numeroNfse").value("7891011"))
                .andExpect(jsonPath("$[0].valorIssqn").value(1500.75))
                .andExpect(jsonPath("$[0].simplesNacional").value(true));
    }

    @Test
    @DisplayName("GET /api/creditos/{nfse} retorna 404 quando lista vazia")
    void porNfse_NotFound() throws Exception {
        when(service.buscarPorNfse("0000")).thenReturn(List.of());

        mockMvc.perform(get("/api/creditos/{nfse}", "0000"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/creditos/credito/{numero} retorna 200 e JSON correto")
    void porCredito_Sucesso() throws Exception {
        var dto = makeDto();
        when(service.buscarPorCredito("123456")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/creditos/credito/{numero}", "123456")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCredito").value("123456"))
                .andExpect(jsonPath("$[0].tipoCredito").value("ISSQN"));
    }

    @Test
    @DisplayName("GET /api/creditos/credito/{numero} retorna 404 quando lista vazia")
    void porCredito_NotFound() throws Exception {
        when(service.buscarPorCredito("000000")).thenReturn(List.of());

        mockMvc.perform(get("/api/creditos/credito/{numero}", "000000"))
                .andExpect(status().isNotFound());
    }
}