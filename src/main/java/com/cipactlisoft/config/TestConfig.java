/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cipactlisoft.config;

/**
 *
 * @author salvador
 */
import com.cipactlisoft.core.ICotizador;
import java.util.List;

public class TestConfig {

    public static void main(String[] args) {
        test_buscarImplementacionesDe();
        test_getCotizador();
        test_calcularPaqueteFinal();
    }

    private static void test_getCotizador() {
        System.out.println("\n============= test_getCotizador() =============");

        ICotizador cotizador = Config.getCotizador();
        System.out.println("Clase instanciada:" + cotizador.getClass().getName());

    }

    private static void test_buscarImplementacionesDe() {
        System.out.println("\n============= test_buscarImplementacionesDe() =============");

        System.out.println("classpath:" + System.getProperty("java.class.path"));

//		Config.buscarRecursoEnClassPath("mx/com/qtx/cotizadorv1ds/cotizadorA/Cotizador.class");		
//		Config.buscarRecursoEnClassPath("mx/com/qtx/cotizadorv1ds/cotizadorA");		
        List<Class<?>> lstImplmICotizador = Config.buscarImplementacionesDe(ICotizador.class, "com.cipactlisoft");
        System.out.println("Implementaciones de ICotizador en el classpath:");
        lstImplmICotizador.forEach(implI -> System.out.println("\t" + implI.getName()));
    }

    private static void test_calcularPaqueteFinal() {
        System.out.println("\n============= test_calcularPaqueteFinal() =============");

        // Ejemplo 1
        String ruta1 = "C:\\Users\\salvador\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Mod3\\src\\main\\java\\com\\cipactlisoft\\casosDeUso";
        String base1 = "com.cipactlisoft";
        System.out.println(Config.calcularPaqueteFinal(ruta1, base1)); // com.cipactlisoft.Proyecto_Mod3.casosDeUso

        // Ejemplo 2
        String ruta2 = "C:\\Users\\salvador\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Mod3\\src\\main\\java\\com\\cipactlisoft\\casosDeUso\\test";
        String base2 = "com.cipactlisoft";
        System.out.println(Config.calcularPaqueteFinal(ruta2, base2)); // com.cipactlisoft.Proyecto_Mod3.casosDeUso.test

    }
}
