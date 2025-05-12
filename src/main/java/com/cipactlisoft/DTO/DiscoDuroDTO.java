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
 * DTO que representa un disco duro en el sistema, hereda de Componente.
 */
public class DiscoDuroDTO extends ComponenteDTO {
    private String capacidadAlm;

    // Constructor vacío
    public DiscoDuroDTO() {
        super();
    }

    // Constructor con todos los campos (incluyendo los heredados)
    public DiscoDuroDTO(String id, String descripcion, String marca, String modelo,
                       BigDecimal costo, BigDecimal precioBase/*, IPromocion promo*/,
                       String capacidadAlm) {
        super(id, descripcion, marca, modelo, costo, precioBase/*, promo*/);
        this.capacidadAlm = capacidadAlm;
    }

    // Getter y Setter para capacidadAlm
    public String getCapacidadAlm() {
        return capacidadAlm;
    }

    public void setCapacidadAlm(String capacidadAlm) {
        this.capacidadAlm = capacidadAlm;
    }

    // Sobrescribe equals para incluir la nueva propiedad
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscoDuroDTO that = (DiscoDuroDTO) o;
        return Objects.equals(capacidadAlm, that.capacidadAlm);
    }

    // Sobrescribe hashCode para incluir la nueva propiedad
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacidadAlm);
    }

    // Sobrescribe toString para incluir la nueva propiedad
    @Override
    public String toString() {
        return "DiscoDuroDTO{" +
                "id='" + getId() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", costo=" + getCosto() +
                ", precioBase=" + getPrecioBase() +
                //", promo=" + getPromo() +
                ", capacidadAlm='" + capacidadAlm + '\'' +
                '}';
    }
}