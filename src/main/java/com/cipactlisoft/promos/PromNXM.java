package com.cipactlisoft.promos;


import com.cipactlisoft.promos.PromBase;
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salvador
 */
public class PromNXM extends PromBase {

    private int lleveN;
    private int pagueM;

    public PromNXM(int n, int m) {
        super(n + " X " + m, "Lleve " + n + ", pague " + m);
        this.lleveN = n;
        this.pagueM = m;
    }

    public int getLleveN() {
        return lleveN;
    }

    public void setLleveN(int lleveN) {
        this.lleveN = lleveN;
    }

    public int getPagueM() {
        return pagueM;
    }

    public void setPagueM(int pagueM) {
        this.pagueM = pagueM;
    }

    /**
     *
     * @param cant
     * @param precioBase
     */
    public BigDecimal calcularImportePromocion(int nUnidades, BigDecimal precioBase) {

        // Calcular grupos completos de N unidades y unidades restantes
        int gruposCompletos = nUnidades / this.lleveN;
        int unidadesRestantes = nUnidades % this.lleveN;

        // Calcular total: (M * grupos) + restantes
        BigDecimal total = precioBase
                .multiply(BigDecimal.valueOf(gruposCompletos * this.pagueM + unidadesRestantes));

        return total;
    }
}