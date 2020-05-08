/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Autoevaluacion;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class AutoevaluacionDaoImplTest {
    
    public AutoevaluacionDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllAutoevaluaciones() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba GetAllAutoevaluaciones", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        autoevaluacionDaoImpl.saveAutoevaluacion(autoevaluacion);
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 2;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba saveAutoevaluacion", resultadoEsperado, resultadoObtenido);
    }
    
    @org.junit.Test
    public void testGetAutoevaluacionByIdAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl;
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion resultadoEsperado = new Autoevaluacion();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Autoevaluacion resultadoObtenido = autoevaluacionDaoImpl.getAutoevaluacionByIdAutoevaluacion("1");
        assertEquals("Prueba getAutoevaluacionByIdAutoevaluacion", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testDeleteAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        autoevaluacionDaoImpl.deleteAutoevaluacion(autoevaluacion);
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals("Prueba deleteAutoevaluacion", resultadoEsperado, resultadoObtenido);
    }
    
}
