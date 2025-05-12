/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.ComponenteDTO;
import com.cipactlisoft.MySQLConnection.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvador
 */
public class ComponenteDAOImpl implements IComponenteDAO {

    public void crear(ComponenteDTO componente) throws SQLException {
        String query = "INSERT INTO componentes (id_componente, descripcion, marca, modelo, costo, precio_base, tipo_componente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, componente.getId());
            stmt.setString(2, componente.getDescripcion());
            stmt.setString(3, componente.getMarca());
            stmt.setString(4, componente.getModelo());
            stmt.setBigDecimal(5, componente.getCosto());
            stmt.setBigDecimal(6, componente.getPrecioBase());
            stmt.setString(7, componente.getClass().getSimpleName().replace("DTO", ""));

            stmt.executeUpdate();
        } finally {
            MySQLConnection.closeResources(stmt, conn);
        }
    }
    
    public ComponenteDTO obtenerPorId(String id) throws SQLException {
        String query = "SELECT * FROM componentes WHERE id_componente = ?";
        ComponenteDTO componente = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = MySQLConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                componente = new ComponenteDTO();
                mapearComponente(rs, componente);
            }
        } finally {
            MySQLConnection.closeResources(rs, stmt, conn);
        }

        return componente;
    }

    public List<ComponenteDTO> obtenerTodos() throws SQLException {
        String query = "SELECT * FROM componentes";
        List<ComponenteDTO> componentes = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = MySQLConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ComponenteDTO componente = new ComponenteDTO();
                mapearComponente(rs, componente);
                componentes.add(componente);
            }
        } finally {
            MySQLConnection.closeResources(rs, stmt, conn);
        }

        return componentes;
    }

    protected void mapearComponente(ResultSet rs, ComponenteDTO componente) throws SQLException {
        componente.setId(rs.getString("id_componente"));
        componente.setDescripcion(rs.getString("descripcion"));
        componente.setMarca(rs.getString("marca"));
        componente.setModelo(rs.getString("modelo"));
        componente.setCosto(rs.getBigDecimal("costo"));
        componente.setPrecioBase(rs.getBigDecimal("precio_base"));
    }
}
