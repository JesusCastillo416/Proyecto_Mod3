/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.MonitorDTO;
import com.cipactlisoft.MySQLConnection.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvador
 */
public class MonitorDAOImpl extends ComponenteDAOImpl implements IMonitorDAO {

    @Override
    public MonitorDTO obtenerMonitorPorId(String id) throws SQLException {
        String query = "SELECT c.*, m.tamano_pantalla, m.resolucion, m.tipo_panel, m.tasa_refresco " +
                      "FROM componentes c JOIN monitores m ON c.id_componente = m.id_componente " +
                      "WHERE c.id_componente = ?";
        
        MonitorDTO monitor = null;
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    monitor = new MonitorDTO();
                    mapearComponente(rs, monitor);
                    monitor.setTamañoPantalla(rs.getString("tamano_pantalla"));
                    monitor.setResolucion(rs.getString("resolucion"));
                    monitor.setTipoPanel(rs.getString("tipo_panel"));
                    monitor.setTasaRefresco(rs.getInt("tasa_refresco"));
                }
            }
        }
        return monitor;
    }

    @Override
    public List<MonitorDTO> obtenerTodosMonitores() throws SQLException {
        String query = "SELECT c.*, m.tamano_pantalla, m.resolucion, m.tipo_panel, m.tasa_refresco " +
                       "FROM componentes c JOIN monitores m ON c.id_componente = m.id_componente";
        
        List<MonitorDTO> monitores = new ArrayList<>();
        
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                MonitorDTO monitor = new MonitorDTO();
                mapearComponente(rs, monitor);
                monitor.setTamañoPantalla(rs.getString("tamano_pantalla"));
                monitor.setResolucion(rs.getString("resolucion"));
                monitor.setTipoPanel(rs.getString("tipo_panel"));
                monitor.setTasaRefresco(rs.getInt("tasa_refresco"));
                monitores.add(monitor);
            }
        }
        return monitores;
    }

    public void crear(MonitorDTO monitor) throws SQLException {
        Connection conn = null;
        try {
            conn = MySQLConnection.getConnection();
            conn.setAutoCommit(false);
            
            // Insertar en componentes
            super.crear(monitor);
            
            // Insertar en monitores
            String query = "INSERT INTO monitores (id_componente, tamano_pantalla, resolucion, tipo_panel, tasa_refresco) " +
                          "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, monitor.getId());
                stmt.setString(2, monitor.getTamañoPantalla());
                stmt.setString(3, monitor.getResolucion());
                stmt.setString(4, monitor.getTipoPanel());
                stmt.setInt(5, monitor.getTasaRefresco());
                stmt.executeUpdate();
            }
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}