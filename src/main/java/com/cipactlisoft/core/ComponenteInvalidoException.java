package com.cipactlisoft.core;

import com.cipactlisoft.componentes.Componente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salvador
 */
public class ComponenteInvalidoException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Componente comp;

    public ComponenteInvalidoException(String message, Componente comp) {
        super(message);
        this.comp = comp;
    }

    public ComponenteInvalidoException(String message, Throwable cause, Componente comp) {
        super(message, cause);
        this.comp = comp;
    }

    public Componente getComp() {
        return comp;
    }

    public void setComp(Componente comp) {
        this.comp = comp;
    }

}
