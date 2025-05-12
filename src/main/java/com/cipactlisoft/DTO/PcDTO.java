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
import java.util.List;
import java.util.Objects;

/**
 * DTO que representa una computadora personal en el sistema, hereda de Componente.
 */
public class PcDTO extends ComponenteDTO {
    private List<ComponenteDTO> subComponentes;
    private static final float DSCTO_PRECIO_AGREGADO = 20.0f;

    // Constructor vacío
    public PcDTO() {
        super();
    }

    // Constructor con todos los campos heredados
    public PcDTO(String id, String descripcion, String marca, String modelo,
                BigDecimal costo, BigDecimal precioBase/*, IPromocion promo*/,
                List<ComponenteDTO> subComponentes) {
        super(id, descripcion, marca, modelo, costo, precioBase/*, promo*/);
        this.subComponentes = subComponentes;
    }

    // Getters y Setters
    public List<ComponenteDTO> getSubComponentes() {
        return subComponentes;
    }

    public void setSubComponentes(List<ComponenteDTO> subComponentes) {
        this.subComponentes = subComponentes;
    }

    public static float getDsctoPrecioAgregado() {
        return DSCTO_PRECIO_AGREGADO;
    }
    
    // equals() incluyendo propiedades heredadas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PcDTO pcDTO = (PcDTO) o;
        return Objects.equals(subComponentes, pcDTO.subComponentes);
    }

    // hashCode() incluyendo propiedades heredadas
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subComponentes);
    }

    // toString() incluyendo propiedades heredadas
    @Override
    public String toString() {
        return "PcDTO{" +
                "id='" + getId() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", costo=" + getCosto() +
                ", precioBase=" + getPrecioBase() +
                //", promo=" + getPromo() +
                ", subComponentes=" + subComponentes +
                ", DSCTO_PRECIO_AGREGADO=" + DSCTO_PRECIO_AGREGADO +
                '}';
    }
}