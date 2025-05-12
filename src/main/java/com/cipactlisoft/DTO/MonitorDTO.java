/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DTO;

/**
 *
 * @author salvador
 */

//import com.cipactlisoft.componentes.IPromocion;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO que representa un monitor en el sistema, hereda de Componente.
 */
public class MonitorDTO extends ComponenteDTO {
    private String tamañoPantalla;  // Ejemplo: "27 pulgadas"
    private String resolucion;      // Ejemplo: "1920x1080"
    private String tipoPanel;       // Ejemplo: "IPS", "TN", "VA"
    private int tasaRefresco;       // Ejemplo: 60, 144, 240 (Hz)

    // Constructor vacío
    public MonitorDTO() {
        super();
    }

    // Constructor con todos los campos
    public MonitorDTO(String id, String descripcion, String marca, String modelo,
                     BigDecimal costo, BigDecimal precioBase/*, IPromocion promo*/,
                     String tamañoPantalla, String resolucion, String tipoPanel, int tasaRefresco) {
        super(id, descripcion, marca, modelo, costo, precioBase/*, promo*/);
        this.tamañoPantalla = tamañoPantalla;
        this.resolucion = resolucion;
        this.tipoPanel = tipoPanel;
        this.tasaRefresco = tasaRefresco;
    }

    // Getters y Setters
    public String getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(String tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPanel() {
        return tipoPanel;
    }

    public void setTipoPanel(String tipoPanel) {
        this.tipoPanel = tipoPanel;
    }

    public int getTasaRefresco() {
        return tasaRefresco;
    }

    public void setTasaRefresco(int tasaRefresco) {
        this.tasaRefresco = tasaRefresco;
    }

    // equals() incluyendo propiedades heredadas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MonitorDTO that = (MonitorDTO) o;
        return tasaRefresco == that.tasaRefresco &&
                Objects.equals(tamañoPantalla, that.tamañoPantalla) &&
                Objects.equals(resolucion, that.resolucion) &&
                Objects.equals(tipoPanel, that.tipoPanel);
    }

    // hashCode() incluyendo propiedades heredadas
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamañoPantalla, resolucion, tipoPanel, tasaRefresco);
    }

    // toString() incluyendo propiedades heredadas
    @Override
    public String toString() {
        return "MonitorDTO{" +
                "id='" + getId() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", costo=" + getCosto() +
                ", precioBase=" + getPrecioBase() +
                //", promo=" + getPromo() +
                ", tamañoPantalla='" + tamañoPantalla + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tipoPanel='" + tipoPanel + '\'' +
                ", tasaRefresco=" + tasaRefresco +
                '}';
    }
}