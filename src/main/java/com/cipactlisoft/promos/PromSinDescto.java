/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.promos;

import java.math.BigDecimal;

/**
 *
 * @author salvador
 */
public class PromSinDescto extends PromBase {

    public PromSinDescto() {
        super("No se aplica ningun descuento", "Precio regular");
    }

    /**
     *
     * @param cant
     * @param precioBase
     */
    public BigDecimal calcularImportePromocion(int cant, BigDecimal precioBase) {
        return precioBase.multiply(new BigDecimal(cant));
    }

}
