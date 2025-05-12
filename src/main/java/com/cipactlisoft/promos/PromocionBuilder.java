/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.promos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author salvador
 */
public class PromocionBuilder {

    static final int PROM_BASE_SIN_DSCTO = 1;
    static final int PROM_BASE_NXM = 2;
    private int tipoPromocionBase;
    private int n;
    private int m;

    private List<Float> lstDsctosPlanos;
    private List<Map<Integer, Double>> lstMapsCantVsDscto;

    public PromocionBuilder() {
        this.lstDsctosPlanos = new ArrayList<>();
        this.lstMapsCantVsDscto = new ArrayList<>();
    }

    int getTipoPromocionBase() {
        return tipoPromocionBase;
    }

    int getN() {
        return n;
    }

    void setN(int n) {
        this.n = n;
    }

    int getM() {
        return m;
    }

    void setM(int m) {
        this.m = m;
    }

    List<Float> getLstDsctosPlanos() {
        return lstDsctosPlanos;
    }

    List<Map<Integer, Double>> getLstMapsCantVsDscto() {
        return lstMapsCantVsDscto;
    }

    public PromocionBuilder conPromocionBaseSinDscto() {
        this.tipoPromocionBase = PROM_BASE_SIN_DSCTO;
        return this;
    }

    /**
     *
     * @param n
     * @param m
     */
    public PromocionBuilder conPromocionBaseNXM(int n, int m) {
        this.tipoPromocionBase = PROM_BASE_NXM;
        this.n = n;
        this.m = m;
        return this;
    }

    /**
     *
     * @param procDscto
     */
    public PromocionBuilder agregarDsctoPlano(float porcDscto) {
        this.lstDsctosPlanos.add(porcDscto);
        return this;

    }

    /**
     *
     * @param mapCantVsDscto
     */
    public PromocionBuilder agregarDsctoXcantidad(Map<Integer, Double> mapCantVsDscto) {
        this.lstMapsCantVsDscto.add(mapCantVsDscto);
        return this;

    }

    public Promocion build() {
        return Promocion.crearPromocion(this);
    }

    @Override
    public String toString() {
        return "PromocionBuilder [tipoPromocionBase=" + tipoPromocionBase + ", n=" + n + ", m=" + m
                + ", lstDsctosPlanos=" + lstDsctosPlanos + ", lstMapsCantVsDscto=" + lstMapsCantVsDscto + "]";
    }

}
