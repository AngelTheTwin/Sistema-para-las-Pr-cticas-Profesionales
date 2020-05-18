/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Reporte;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testGetAllReportes() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 1;
        int resultadoObtenido = reportes.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba GetAllHorarios ");
    }

    @Test
    public void testGetReporteByIdReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte resultadoEsperado = new Reporte();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Reporte resultadoObtenido = reporteDaoImpl.getReporteByIdReporte("1");
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba getReporteByIdReporte");
    }

    @Test
    public void testSaveReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte reporte = new Reporte();
        reporte.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        reporteDaoImpl.saveReporte(reporte);
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 2;
        int resultadoObtenido = reportes.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba saveReporte ");
    }

    @Test
    public void testDeleteReporte() {
        ReporteDaoImpl reporteDaoImpl;
        reporteDaoImpl = new ReporteDaoImpl();
        Reporte reporte = new Reporte();
        reporte.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        reporteDaoImpl.deleteReporte(reporte);
        List <Reporte> reportes = reporteDaoImpl.getAllReportes();
        int resultadoEsperado = 1;
        int resultadoObtenido = reportes.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba deleteReporte ");
    }
    
}
