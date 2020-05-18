/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Autoevaluacion;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class AutoevaluacionDaoImplTest {
    
    public AutoevaluacionDaoImplTest() {
        this.testGetAutoevaluacionByIdAutoevaluacion();
        this.testGetAllAutoevaluaciones();
        this.testSaveAutoevaluacion();
        this.testDeleteAutoevaluacion();
    }

    @Test
    public void testGetAllAutoevaluaciones() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba GetAllAutoevaluaciones ");
    }

    @Test
    public void testGetAutoevaluacionByIdAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl;
        autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion resultadoEsperado = new Autoevaluacion();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Autoevaluacion resultadoObtenido = autoevaluacionDaoImpl.getAutoevaluacionByIdAutoevaluacion("1");
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba getAutoevaluacionByIdAutoevaluacion");
    }

    @Test
    public void testSaveAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        autoevaluacionDaoImpl.saveAutoevaluacion(autoevaluacion);
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 2;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba saveAutoevaluacion ");
    }

    @Test
    public void testDeleteAutoevaluacion() {
        AutoevaluacionDaoImpl autoevaluacionDaoImpl = new AutoevaluacionDaoImpl();
        Autoevaluacion autoevaluacion = new Autoevaluacion();
        autoevaluacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        autoevaluacionDaoImpl.deleteAutoevaluacion(autoevaluacion);
        List <Autoevaluacion> autoevaluaciones = autoevaluacionDaoImpl.getAllAutoevaluaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = autoevaluaciones.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba deleteAutoevaluacion ");
    }
    
}
