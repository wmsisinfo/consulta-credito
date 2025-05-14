package br.com.eicon.consulta_creditos.dto;

import java.time.LocalDateTime;

public class ConsultaRealizadaEvent {
    private String tipoConsulta;
    private String valorConsultado;
    private int totalResultados;
    private LocalDateTime dataHora = LocalDateTime.now();
    private String ipCliente;

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getValorConsultado() {
        return valorConsultado;
    }

    public void setValorConsultado(String valorConsultado) {
        this.valorConsultado = valorConsultado;
    }

    public int getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(int totalResultados) {
        this.totalResultados = totalResultados;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }
}
