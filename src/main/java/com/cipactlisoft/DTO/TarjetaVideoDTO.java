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
 * DTO que representa una tarjeta de video en el sistema, hereda de Componente.
 */
public class TarjetaVideoDTO extends ComponenteDTO {
    private String memoria;  // Ejemplo: "8GB GDDR6"

    // Constructor vacío
    public TarjetaVideoDTO() {
        super();
    }

    // Constructor con todos los campos
    public TarjetaVideoDTO(String id, String descripcion, String marca, String modelo,
                          BigDecimal costo, BigDecimal precioBase/*, IPromocion promo*/,
                          String memoria) {
        super(id, descripcion, marca, modelo, costo, precioBase/*, promo*/);
        this.memoria = memoria;
    }

    // Getter y Setter para memoria
    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    // equals() incluyendo propiedades heredadas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TarjetaVideoDTO that = (TarjetaVideoDTO) o;
        return Objects.equals(memoria, that.memoria);
    }

    // hashCode() incluyendo propiedades heredadas
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memoria);
    }

    // toString() incluyendo propiedades heredadas
    @Override
    public String toString() {
        return "TarjetaVideoDTO{" +
                "id='" + getId() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", costo=" + getCosto() +
                ", precioBase=" + getPrecioBase() +
                //", promo=" + getPromo() +
                ", memoria='" + memoria + '\'' +
                '}';
    }
}