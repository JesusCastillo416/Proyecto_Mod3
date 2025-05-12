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

public class ComponenteDTO {
    protected String id;
    protected String descripcion;
    protected String marca;
    protected String modelo;
    protected BigDecimal costo;
    protected BigDecimal precioBase;
    //protected IPromocion promo;

    // Constructor vacío
    public ComponenteDTO() {
    }

    // Constructor con todos los campos
    public ComponenteDTO(String id, String descripcion, String marca, String modelo, 
                     BigDecimal costo, BigDecimal precioBase/*, IPromocion promo*/) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
        this.precioBase = precioBase;
        //this.promo = promo;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }
/*
    public IPromocion getPromo() {
        return promo;
    }

    public void setPromo(IPromocion promo) {
        this.promo = promo;
    }
*/
    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponenteDTO that = (ComponenteDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(modelo, that.modelo) &&
                Objects.equals(costo, that.costo) &&
                Objects.equals(precioBase, that.precioBase); //&&
                //Objects.equals(promo, that.promo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, marca, modelo, costo, precioBase/*, promo*/);
    }

    // Método toString
    @Override
    public String toString() {
        return "Componente{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                ", precioBase=" + precioBase +
                //", promo=" + promo +
                '}';
    }
}
