/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.ActividadRealizada;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class ActividadRealizadaDaoImplTest {
    
    public ActividadRealizadaDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllActividadesRealizadas() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 1;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals("Prueba GetAllActividadesRealizadas", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada actividadRealizada = new ActividadRealizada();
        actividadRealizada.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        actividadDaoImpl.saveActividadRealizada(actividadRealizada);
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 2;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals("Prueba saveActividadRealizada", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testDeleteActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada actividadRealizada = new ActividadRealizada();
        actividadRealizada.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        actividadDaoImpl.deleteActividadRealizada(actividadRealizada);
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 1;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals("Prueba deleteActividadRealizada", resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetActividadRealizadaByIdActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl;
        actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada resultadoEsperado = new ActividadRealizada();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        ActividadRealizada resultadoObtenido = actividadDaoImpl.getActividadRealizadaByIdActividadRealizada("1");
        assertEquals("Prueba getActividadRealizadaByIdActividadRealizada", resultadoEsperado, resultadoObtenido);
    }
    
}
