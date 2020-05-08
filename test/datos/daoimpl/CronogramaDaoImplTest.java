/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Cronograma;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class CronogramaDaoImplTest {
    
    public CronogramaDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllCronogramas() {
        CronogramaDaoImpl cronogramaDaoImpl = new CronogramaDaoImpl();
        List <Cronograma> cronogramas = cronogramaDaoImpl.getAllCronogramas();
        int resultadoEsperado = 1;
        int resultadoObtenido = cronogramas.size();
        assertEquals("Prueba GetAllAutoevaluaciones", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetCronogramaByIdCronograma() {
        CronogramaDaoImpl cronogramaDaoImpl;
        cronogramaDaoImpl = new CronogramaDaoImpl();
        Cronograma resultadoEsperado = new Cronograma();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Cronograma resultadoObtenido = cronogramaDaoImpl.getCronogramaByIdCronograma("1");
        assertEquals("Prueba getCronogramaByIdCronograma", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveCronograma() {
        CronogramaDaoImpl cronogramaDaoImpl = new CronogramaDaoImpl();
        Cronograma cronograma = new Cronograma();
        cronograma.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        cronogramaDaoImpl.saveCronograma(cronograma);
        List <Cronograma> cronogramas = cronogramaDaoImpl.getAllCronogramas();
        int resultadoEsperado = 2;
        int resultadoObtenido = cronogramas.size();
        assertEquals("Prueba saveCronograma", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testDeleteCronograma() {
        CronogramaDaoImpl cronogramaDaoImpl = new CronogramaDaoImpl();
        Cronograma cronograma = new Cronograma();
        cronograma.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        cronogramaDaoImpl.deleteCronograma(cronograma);
        List <Cronograma> cronogramas = cronogramaDaoImpl.getAllCronogramas();
        int resultadoEsperado = 1;
        int resultadoObtenido = cronogramas.size();
        assertEquals("Prueba deleteCronograma", resultadoEsperado, resultadoObtenido);
    }
    
}
