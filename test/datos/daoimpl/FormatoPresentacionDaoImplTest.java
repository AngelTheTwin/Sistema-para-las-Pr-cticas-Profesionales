/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.FormatoPresentacion;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class FormatoPresentacionDaoImplTest {
    
    public FormatoPresentacionDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllPresentaciones() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals("Prueba GetAllPresentaciones", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetFormatoPresentacionByIdFormato() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion resultadoEsperado = new FormatoPresentacion();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        FormatoPresentacion resultadoObtenido = formatoPresentacionDaoImpl.getFormatoPresentacionByIdFormato("1");
        assertEquals("Prueba getFormatoPresentacionByIdFormato", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveFormatoPresentacion() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion formatoPresentacion = new FormatoPresentacion();
        formatoPresentacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        formatoPresentacionDaoImpl.saveFormatoPresentacion(formatoPresentacion);
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 2;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals("Prueba saveFormatoPresentacion", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testDeleteFormatoPresentacion() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion formatoPresentacion = new FormatoPresentacion();
        formatoPresentacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        formatoPresentacionDaoImpl.deleteFormatoPresentacion(formatoPresentacion);
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals("Prueba deleteFormatoPresentacion", resultadoEsperado, resultadoObtenido);
    }
    
}
