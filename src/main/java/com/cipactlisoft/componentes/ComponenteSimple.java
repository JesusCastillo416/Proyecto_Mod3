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

public abstract class ComponenteSimple extends Componente {

    public ComponenteSimple(String id, String descripcion, String marca, String modelo, BigDecimal costo,
            BigDecimal precioBase) {
        super(id, descripcion, marca, modelo, costo, precioBase);
    }

}
