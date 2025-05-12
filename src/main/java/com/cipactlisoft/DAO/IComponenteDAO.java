/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cipactlisoft.DAO;


import com.cipactlisoft.DTO.ComponenteDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author salvador
 */
public interface IComponenteDAO {

    void crear(ComponenteDTO componente) throws SQLException;

    ComponenteDTO obtenerPorId(String id) throws SQLException;

    List<ComponenteDTO> obtenerTodos() throws SQLException;
}
