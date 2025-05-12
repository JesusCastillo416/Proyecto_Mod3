/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cipactlisoft.DAO;

import com.cipactlisoft.DTO.ComponenteDTO;
import com.cipactlisoft.DTO.PcDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author salvador
 */

public interface IPcDAO extends IComponenteDAO {
    List<PcDTO> obtenerTodasPcs() throws SQLException;
    PcDTO obtenerPcPorId(String id) throws SQLException;
    void agregarComponenteAPc(String idPc, String idComponente, int cantidad) throws SQLException;
    List<ComponenteDTO> obtenerComponentesDePc(String idPc) throws SQLException;
}