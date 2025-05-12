/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.componentes;

/**
 *
 * @author salvador
 */
import java.math.BigDecimal;

public class Monitor extends ComponenteSimple {

//	private static Map<Integer, Double> mapDsctos = Map.of(0,  0.0,
//														   3,  5.0,
//														   6, 10.0,
//														   9, 12.0);
    protected Monitor(String id, String descripcion, String marca, String modelo, BigDecimal costo,
            BigDecimal precioBase) {
        super(id, descripcion, marca, modelo, costo, precioBase);
    }

//	public BigDecimal cotizar(int cantidadI) {
//		return PromocionUtil.calcularPrecioPromocionDsctoXcant(cantidadI, this.precioBase, mapDsctos);
//	}
    @Override
    public String getCategoria() {
        return "Monitor";
    }

}
