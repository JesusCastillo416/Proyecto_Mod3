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
                System.out.println("\nPC: " + pc.getDescripcion()
                        + " - Precio Base: $" + pc.getPrecioBase());
                System.out.println("Componentes incluidos:");
                pc.getSubComponentes().forEach(comp
                        -> System.out.println(" - " + comp.getDescripcion()
                                + " (" + comp.getMarca() + ")"));
            });

        } catch (SQLException e) {
            System.out.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
        
        
        //testCreacionPC();

//    	testAgregarComponentes();
//    	testEliminarComponente();
        //testGenerarCotizacion();
//    	testMostrarCaracteristicas();

//    	testCreacionPcOk_conPcBuilder();
//    	testCreacionPcErroneo_conPcBuilder_DiscosDeMas();
//    	testCreacionPcErroneo_conPcBuilder_SinDiscos();
//    }
    /*
    

    private static void testGenerarCotizacion() {

        ICotizador cotizador = getCotizadorActual();

        Componente monitor = Componente.crearMonitor("M001", "Monitor 17 pulgadas", "Samsung", "Goliat-500",
                new BigDecimal(1000), new BigDecimal(2000));
        cotizador.agregarComponente(1, monitor);

        Componente monitor2 = Componente.crearMonitor("M022", "Monitor 15 pulgadas", "Sony", "VR-30",
                new BigDecimal(1100), new BigDecimal(2000));
        cotizador.agregarComponente(4, monitor2);
        cotizador.agregarComponente(7, monitor2);

        Componente disco = Componente.crearDiscoDuro("D-23", "Disco estado sólido", "Seagate", "T-455", new BigDecimal(500),
                new BigDecimal(1000), "2TB");
        cotizador.agregarComponente(10, disco);

        Componente tarjeta = Componente.crearTarjetaVideo("C0XY", "Tarjeta THOR", "TechBrand", "X200-34",
                new BigDecimal("150.00"), new BigDecimal("300.00"), "8GB");
        cotizador.agregarComponente(10, tarjeta);

        Componente discoPc = Componente.crearDiscoDuro("D001", "Disco Seagate", "TechXYZ", "X200",
                new BigDecimal("1880.00"), new BigDecimal("2000.00"), "1TB");
        Componente monitorPc = Componente.crearMonitor("M001", "Monitor 17 pulgadas", "Sony", "Z9000",
                new BigDecimal("3200.00"), new BigDecimal("6000.00"));
        Componente tarjetaPc = Componente.crearTarjetaVideo("C001", "Tarjeta XYZ", "TechBrand", "X200",
                new BigDecimal("150.00"), new BigDecimal("200.00"), "16GB");

        Componente miPc = Componente.crearPc("pc0001", "Laptop 15000 s300", "Dell", "Terminator",
                List.of(discoPc, monitorPc, tarjetaPc));
        cotizador.agregarComponente(1, miPc);
        Cotizacion cotizacion = cotizador.generarCotizacion();
        cotizacion.emitirComoReporte();
    }

    private static ICotizador getCotizadorActual() {
        return Config.getCotizador();
    }

    
     */
    }
}