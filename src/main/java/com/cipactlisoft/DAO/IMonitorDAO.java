/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.MonitorDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author salvador
 */

public interface IMonitorDAO extends IComponenteDAO {
    List<MonitorDTO> obtenerTodosMonitores() throws SQLException;
    MonitorDTO obtenerMonitorPorId(String id) throws SQLException;
}