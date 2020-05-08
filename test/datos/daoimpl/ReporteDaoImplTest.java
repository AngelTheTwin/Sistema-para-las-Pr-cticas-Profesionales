/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Reporte;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class ReporteDaoImplTest {
    
    public ReporteDaoImplTest() {
        this.testGetReporteByIdReporte();
        this.testGetAllReportes();
        this.testSaveReporte();
        this.testDeleteReporte();
    }

    @org.junit.Test
    public void testGetAllReportes() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 1;
        int resultadoObtenido = reportes.size();
        assertEquals("Prueba GetAllHorarios", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetReporteByIdReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte resultadoEsperado = new Reporte();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Reporte resultadoObtenido = reporteDaoImpl.getReporteByIdReporte("1");
        assertEquals("Prueba getReporteByIdReporte", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte reporte = new Reporte();
        reporte.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        reporteDaoImpl.saveReporte(reporte);
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 2;
        int resultadoObtenido = reportes.size();
        assertEquals("Prueba saveReporte", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testDeleteReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte reporte = new Reporte();
        reporte.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        reporteDaoImpl.deleteReporte(reporte);
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 1;
        int resultadoObtenido = reportes.size();
        assertEquals("Prueba deleteReporte", resultadoEsperado, resultadoObtenido);
    }   
}
