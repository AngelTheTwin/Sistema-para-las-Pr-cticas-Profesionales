/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Autoevaluacion;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author angel
 */
public class AutoevaluacionDaoImplTest {
    static AutoevaluacionDaoImpl autoevaluacionDaoImpl;
    static Autoevaluacion autoevaluacion;
    static List<Autoevaluacion> autoevaluacionesDePrueba;
    
    public AutoevaluacionDaoImplTest() {
    }
    
    @BeforeClass
    public static void prepararEntornoDePruebas(){
        autoevaluacionesDePrueba = new ArrayList<>();
        
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/Modelos_desarrollo1.pdf");
        autoevaluacion.setIdAutoevaluacion(1);
        autoevaluacionDaoImpl.saveAutoevaluacion(autoevaluacion);
        autoevaluacionesDePrueba.add(autoevaluacion);
        
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/Cuadro Sinóptico en Blanco.pdf");
        autoevaluacion.setIdAutoevaluacion(2);
        autoevaluacionDaoImpl.saveAutoevaluacion(autoevaluacion);
        autoevaluacionesDePrueba.add(autoevaluacion);
    }
    
    @Before
    public void antesDecadaPrueba(){
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
    }
    
    @AfterClass
    public static void cerrarEntornoDePruebas(){
        System.out.println("Cerrar Entorno de Pruebas");
        autoevaluacionesDePrueba.forEach((autoevaluacionDePrueba) -> {
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        autoevaluacionDaoImpl.deleteAutoevaluacion(autoevaluacionDePrueba);
        });
    }
    
    @org.junit.Test
    public void testGetAllAutoevaluaciones() {
        System.out.println("testGetAllEvaluaciones");
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba GetAllAutoevaluaciones", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveAutoevaluacion() {
        System.out.println("testSaveEvaluacion");
        autoevaluacionDaoImpl.saveAutoevaluacion(autoevaluacion);
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 2;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba saveAutoevaluacion", resultadoEsperado, resultadoObtenido);
    }
    
    @org.junit.Test
    public void testGetAutoevaluacionByIdAutoevaluacion() {
        System.out.println("testGetAutoevaluacionByIdAutoevaluacion");
        Autoevaluacion resultadoObtenido = autoevaluacionDaoImpl.getAutoevaluacionByIdAutoevaluacion(1);
        int resultadoEsperado = 1;
        assertEquals("Prueba getAutoevaluacionByIdAutoevaluacion", resultadoEsperado, resultadoObtenido.getIdAutoevaluacion());
    }

    @org.junit.Test
    public void testDeleteAutoevaluacion() {
        System.out.println("testDeleteAutoevaluacion");
        autoevaluacionDaoImpl.deleteAutoevaluacion(autoevaluacion);
        System.out.println("Delete autoevaluacion" + autoevaluacion.getIdAutoevaluacion());
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba deleteAutoevaluacion", resultadoEsperado, resultadoObtenido);
    }
    
}
