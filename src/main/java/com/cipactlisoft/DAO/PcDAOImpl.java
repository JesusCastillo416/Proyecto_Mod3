/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.ComponenteDTO;
import com.cipactlisoft.DTO.PcDTO;
import com.cipactlisoft.MySQLConnection.MySQLConnection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvador
 */
public class PcDAOImpl extends ComponenteDAOImpl implements IPcDAO {

    @Override
    public PcDTO obtenerPcPorId(String id) throws SQLException {
        String query = "SELECT c.*, p.descuento_precio_agregado FROM componentes c " +
                      "JOIN pcs p ON c.id_componente = p.id_componente " +
                      "WHERE c.id_componente = ?";
        
        PcDTO pc = null;
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pc = new PcDTO();
                    mapearComponente(rs, pc);
                    //pc.setDescuentoPrecioAgregado(rs.getFloat("descuento_precio_agregado"));
                    pc.setSubComponentes(obtenerComponentesDePc(id));
                }
            }
        }
        return pc;
    }

    @Override
    public List<PcDTO> obtenerTodasPcs() throws SQLException {
        String query = "SELECT c.*, p.descuento_precio_agregado FROM componentes c " +
                       "JOIN pcs p ON c.id_componente = p.id_componente";
        
        List<PcDTO> pcs = new ArrayList<>();
        
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                PcDTO pc = new PcDTO();
                mapearComponente(rs, pc);
                //pc.setDescuentoPrecioAgregado(rs.getFloat("descuento_precio_agregado"));
                pc.setSubComponentes(obtenerComponentesDePc(pc.getId()));
                pcs.add(pc);
            }
        }
        return pcs;
    }

    @Override
    public void agregarComponenteAPc(String idPc, String idComponente, int cantidad) throws SQLException {
        String query = "INSERT INTO pc_componentes (id_pc, id_componente, cantidad) VALUES (?, ?, ?) " +
                      "ON DUPLICATE KEY UPDATE cantidad = cantidad + VALUES(cantidad)";
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, idPc);
            stmt.setString(2, idComponente);
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<ComponenteDTO> obtenerComponentesDePc(String idPc) throws SQLException {
        String query = "SELECT c.* FROM componentes c " +
                      "JOIN pc_componentes pc ON c.id_componente = pc.id_componente " +
                      "WHERE pc.id_pc = ?";
        
        List<ComponenteDTO> componentes = new ArrayList<>();
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, idPc);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ComponenteDTO componente = new ComponenteDTO();
                    mapearComponente(rs, componente);
                    componentes.add(componente);
                }
            }
        }
        return componentes;
    }
    
    public void crear(PcDTO pc) throws SQLException {
        Connection conn = null;
        try {
            conn = MySQLConnection.getConnection();
            conn.setAutoCommit(false);
            
            super.crear(pc);
            
            String query = "INSERT INTO pcs (id_componente, descuento_precio_agregado) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, pc.getId());
                stmt.setFloat(2, PcDTO.getDsctoPrecioAgregado());
                stmt.executeUpdate();
            }
            
            // Agregar componentes si existen
            if (pc.getSubComponentes() != null && !pc.getSubComponentes().isEmpty()) {
                for (ComponenteDTO componente : pc.getSubComponentes()) {
                    agregarComponenteAPc(pc.getId(), componente.getId(), 1);
                }
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