package com.projectONE.services;

import com.projectONE.modules.TasaDeCambio;

public class ConversionDivisa {

    public static Double Conversion(Double monto, TasaDeCambio cambio){
        return monto * cambio.getValor();
    }
}
