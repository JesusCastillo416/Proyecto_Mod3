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
public class PromDsctoPlano extends PromAcumulable {

    private float porcDescto; // Se recibe como 7.5 para 7.5%

    public PromDsctoPlano(Promocion promoBase, float porcDescto) {
        super(String.format("Descuento Plano del %4.2f %%", porcDescto), "Dscto Plano", promoBase);
        this.porcDescto = porcDescto;
    }

    /**
     *
     * @param cant
     * @param precioBase
     */
    public BigDecimal calcularImportePromocion(int cant, BigDecimal precioBase) {
        BigDecimal baseCalculo = this.promoBase.calcularImportePromocion(cant, precioBase);
        BigDecimal porcDscto = new BigDecimal(porcDescto).divide(new BigDecimal(100));
        BigDecimal importeDscto = baseCalculo.multiply(porcDscto);
        return baseCalculo.subtract(importeDscto);
    }

}
