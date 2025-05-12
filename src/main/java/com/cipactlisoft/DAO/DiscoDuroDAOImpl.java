/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.DiscoDuroDTO;
import com.cipactlisoft.MySQLConnection.MySQLConnection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvador
 */

public class DiscoDuroDAOImpl extends ComponenteDAOImpl implements IDiscoDuroDAO {

    @Override
    public DiscoDuroDTO obtenerDiscoPorId(String id) throws SQLException {
        String query = "SELECT c.*, d.capacidad_alm FROM componentes c " +
                      "JOIN discos_duros d ON c.id_componente = d.id_componente " +
                      "WHERE c.id_componente = ?";
        
        DiscoDuroDTO disco = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = MySQLConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                disco = new DiscoDuroDTO();
                mapearComponente(rs, disco);
                disco.setCapacidadAlm(rs.getString("capacidad_alm"));
            }
        } finally {
            MySQLConnection.closeResources(rs, stmt, conn);
        }
        
        return disco;
    }

    @Override
    public List<DiscoDuroDTO> obtenerTodosDiscos() throws SQLException {
        String query = "SELECT c.*, d.capacidad_alm FROM componentes c " +
                       "JOIN discos_duros d ON c.id_componente = d.id_componente";
        
        List<DiscoDuroDTO> discos = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = MySQLConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                DiscoDuroDTO disco = new DiscoDuroDTO();
                mapearComponente(rs, disco);
                disco.setCapacidadAlm(rs.getString("capacidad_alm"));
                discos.add(disco);
            }
        } finally {
            MySQLConnection.closeResources(rs, stmt, conn);
        }
        
        return discos;
    }
    
    public void crear(DiscoDuroDTO disco) throws SQLException {
        Connection conn = null;
        try {
            conn = MySQLConnection.getConnection();
            conn.setAutoCommit(false);
            
            // 1. Insertar en componentes
            super.crear(disco);
            
            // 2. Insertar en discos_duros
            String query = "INSERT INTO discos_duros (id_componente, capacidad_alm) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, disco.getId());
                stmt.setString(2, disco.getCapacidadAlm());
                stmt.executeUpdate();
            }
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) conn.setAutoCommit(true);
            MySQLConnection.closeResources(conn);
        }
    }
}