/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cipactlisoft.casosDeUso;

import com.cipactlisoft.DAO.DiscoDuroDAOImpl;
import com.cipactlisoft.DAO.IDiscoDuroDAO;
import com.cipactlisoft.DAO.IMonitorDAO;
import com.cipactlisoft.DAO.IPcDAO;
import com.cipactlisoft.DAO.ITarjetaVideoDAO;
import com.cipactlisoft.DAO.MonitorDAOImpl;
import com.cipactlisoft.DAO.PcDAOImpl;
import com.cipactlisoft.DAO.TarjetaVideoDAOImpl;
import com.cipactlisoft.DTO.ComponenteDTO;
import com.cipactlisoft.DTO.MonitorDTO;
import com.cipactlisoft.DTO.PcDTO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author salvador
 */
public class Proyecto_Mod3 {

    public static void main(String[] args) {
        try {
            // Obtener DAOs
            IPcDAO pcDAO = new PcDAOImpl();
            IMonitorDAO monitorDAO = new MonitorDAOImpl();
            ITarjetaVideoDAO tarjetaDAO = new TarjetaVideoDAOImpl();
            IDiscoDuroDAO discoDAO = new DiscoDuroDAOImpl();
            
            // Crear componentes
            /*MonitorDTO monitor = new MonitorDTO();
            monitor.setId("MON004");
            monitor.setDescripcion("Monitor UltraWide 38\"");
            monitor.setMarca("LG");
            monitor.setModelo("38WN95C");
            monitor.setCosto(new BigDecimal("800.00"));
            monitor.setPrecioBase(new BigDecimal("1299.99"));
            monitor.setTamañoPantalla("38\"");
            monitor.setResolucion("3840x1600");
            monitor.setTipoPanel("Nano IPS");
            monitor.setTasaRefresco(144);
            
            monitorDAO.crear(monitor);
            */
            // Crear una PC con componentes
           /*
            PcDTO nuevaPc = new PcDTO();
            nuevaPc.setId("PC004");
            nuevaPc.setDescripcion("PC Workstation Premium");
            nuevaPc.setMarca("Custom");
            nuevaPc.setModelo("Workstation Pro");
            nuevaPc.setCosto(new BigDecimal("1500.00"));
            nuevaPc.setPrecioBase(new BigDecimal("2499.99"));
            */
            // Agregar componentes a la PC
            /*List<ComponenteDTO> componentes = new ArrayList<>();
            componentes.add(tarjetaDAO.obtenerTarjetaPorId("GPU003")); // RTX 4090
            componentes.add(monitorDAO.obtenerMonitorPorId("MON004")); // Nuevo monitor
            componentes.add(discoDAO.obtenerDiscoPorId("DD002")); // SSD NVMe 1TB
            
            nuevaPc.setSubComponentes(componentes);
            pcDAO.crear(nuevaPc);
            */
            // Consultar PCs
            System.out.println("\n--- PCs en el sistema ---");
            List<PcDTO> pcs = pcDAO.obtenerTodasPcs();
            pcs.forEach(pc -> {
                System.out.println("\nPC: " + pc.getDescripcion() + 
                                 " - Precio Base: $" + pc.getPrecioBase());
                System.out.println("Componentes incluidos:");
                pc.getSubComponentes().forEach(comp -> 
                    System.out.println(" - " + comp.getDescripcion() + 
                                     " (" + comp.getMarca() + ")"));
            });
            
        } catch (SQLException e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
