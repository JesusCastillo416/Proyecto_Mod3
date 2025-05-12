/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.TarjetaVideoDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author salvador
 */

public interface ITarjetaVideoDAO extends IComponenteDAO {
    List<TarjetaVideoDTO> obtenerTodasTarjetas() throws SQLException;
    TarjetaVideoDTO obtenerTarjetaPorId(String id) throws SQLException;
}