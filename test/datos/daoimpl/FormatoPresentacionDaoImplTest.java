/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.FormatoPresentacion;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class FormatoPresentacionDaoImplTest {
    
    public FormatoPresentacionDaoImplTest() {
        this.testGetFormatoPresentacionByIdFormato();
        this.testGetAllPresentaciones();
        this.testSaveFormatoPresentacion();
        this.testDeleteFormatoPresentacion();
    }

    @Test
    public void testGetAllPresentaciones() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba GetAllPresentaciones ");
    }

    @Test
    public void testGetFormatoPresentacionByIdFormato() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion resultadoEsperado = new FormatoPresentacion();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        FormatoPresentacion resultadoObtenido = formatoPresentacionDaoImpl.getFormatoPresentacionByIdFormato("1");
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba getFormatoPresentacionByIdFormato");
    }

    @Test
    public void testSaveFormatoPresentacion() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion formatoPresentacion = new FormatoPresentacion();
        formatoPresentacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        formatoPresentacionDaoImpl.saveFormatoPresentacion(formatoPresentacion);
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 2;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba saveFormatoPresentacion");
    }

    @Test
    public void testDeleteFormatoPresentacion() {
        FormatoPresentacionDaoImpl formatoPresentacionDaoImpl;
        formatoPresentacionDaoImpl = new FormatoPresentacionDaoImpl();
        FormatoPresentacion formatoPresentacion = new FormatoPresentacion();
        formatoPresentacion.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        formatoPresentacionDaoImpl.deleteFormatoPresentacion(formatoPresentacion);
        List <FormatoPresentacion> formatosPresentacion = formatoPresentacionDaoImpl.getAllPresentaciones();
        int resultadoEsperado = 1;
        int resultadoObtenido = formatosPresentacion.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba deleteFormatoPresentacion");
    }
    
}
