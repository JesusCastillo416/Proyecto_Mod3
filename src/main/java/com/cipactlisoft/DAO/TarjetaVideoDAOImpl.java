/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.TarjetaVideoDTO;
import com.cipactlisoft.MySQLConnection.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvador
 */
public class TarjetaVideoDAOImpl extends ComponenteDAOImpl implements ITarjetaVideoDAO {

    @Override
    public TarjetaVideoDTO obtenerTarjetaPorId(String id) throws SQLException {
        String query = "SELECT c.*, t.memoria FROM componentes c " +
                      "JOIN tarjetas_video t ON c.id_componente = t.id_componente " +
                      "WHERE c.id_componente = ?";
        
        TarjetaVideoDTO tarjeta = null;
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tarjeta = new TarjetaVideoDTO();
                    mapearComponente(rs, tarjeta);
                    tarjeta.setMemoria(rs.getString("memoria"));
                }
            }
        }
        return tarjeta;
    }

    @Override
    public List<TarjetaVideoDTO> obtenerTodasTarjetas() throws SQLException {
        String query = "SELECT c.*, t.memoria FROM componentes c " +
                       "JOIN tarjetas_video t ON c.id_componente = t.id_componente";
        
        List<TarjetaVideoDTO> tarjetas = new ArrayList<>();
        
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                TarjetaVideoDTO tarjeta = new TarjetaVideoDTO();
                mapearComponente(rs, tarjeta);
                tarjeta.setMemoria(rs.getString("memoria"));
                tarjetas.add(tarjeta);
            }
        }
        return tarjetas;
    }

    public void crear(TarjetaVideoDTO tarjeta) throws SQLException {
        Connection conn = null;
        try {
            conn = MySQLConnection.getConnection();
            conn.setAutoCommit(false);
            
            super.crear(tarjeta);
            
            String query = "INSERT INTO tarjetas_video (id_componente, memoria) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, tarjeta.getId());
                stmt.setString(2, tarjeta.getMemoria());
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