/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.promos;

/**
 *
 * @author salvador
 */
public abstract class PromAcumulable extends Promocion {

    protected Promocion promoBase;

    public PromAcumulable(String descripcion, String nombre, Promocion promoBase) {
        super(descripcion, nombre);
        this.promoBase = promoBase;
    }

    /**
     *
     * @param cant
     * @param precioBase
     */
//	public abstract BigDecimal calcularImportePromocion(int cant, BigDecimal precioBase);
}
