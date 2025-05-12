package com.cipactlisoft.componentes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author salvador
 */
import java.math.BigDecimal;

public interface IPromocion {
	BigDecimal calcularImportePromocion(int cant, BigDecimal precioBase);
}
