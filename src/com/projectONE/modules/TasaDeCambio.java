package com.projectONE.modules;

public class TasaDeCambio {
    private Double valor;

    public TasaDeCambio(TasaActual cambio) {
        this.valor = cambio.conversion_rate();
    }

    public Double getValor() {
        return valor;
    }
}
