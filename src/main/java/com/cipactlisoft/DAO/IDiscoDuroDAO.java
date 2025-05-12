/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.DiscoDuroDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author salvador
 */
public interface IDiscoDuroDAO extends IComponenteDAO {

    List<DiscoDuroDTO> obtenerTodosDiscos() throws SQLException;

    DiscoDuroDTO obtenerDiscoPorId(String id) throws SQLException;
}
