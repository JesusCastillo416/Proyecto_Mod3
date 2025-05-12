/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cipactlisoft.core;

import com.cipactlisoft.componentes.Componente;

/**
 *
 * @author salvador
 */
public interface ICotizador {
    void agregarComponente(int cantidad, Componente componente);
    void eliminarComponente(String idComponente) throws ComponenteInvalidoException;
    Cotizacion generarCotizacion();
    void listarComponentes();
}
