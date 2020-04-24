/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.ActividadRealizada;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class ActividadRealizadaDaoImplTest {
    
    public ActividadRealizadaDaoImplTest() {
        this.testGetActividadRealizadaByIdActividadRealizada();
        this.testGetAllActividadesRealizadas();
        this.testSaveActividadRealizada();
        this.testDeleteActividadRealizada();
    }

    @Test
    public void testGetAllActividadesRealizadas() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 1;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba GetAllActividadesRealizadas ");
    }

    @Test
    public void testSaveActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada actividadRealizada = new ActividadRealizada();
        actividadRealizada.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        actividadDaoImpl.saveActividadRealizada(actividadRealizada);
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 2;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba saveActividadRealizada ");
    }

    @Test
    public void testDeleteActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada actividadRealizada = new ActividadRealizada();
        actividadRealizada.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        actividadDaoImpl.deleteActividadRealizada(actividadRealizada);
        List <ActividadRealizada> actividadesRealizadas = actividadDaoImpl.getAllActividadesRealizadas();
        int resultadoEsperado = 1;
        int resultadoObtenido = actividadesRealizadas.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba deleteActividadRealizada ");
    }

    @Test
    public void testGetActividadRealizadaByIdActividadRealizada() {
        ActividadRealizadaDaoImpl actividadDaoImpl;
        actividadDaoImpl = new ActividadRealizadaDaoImpl();
        ActividadRealizada resultadoEsperado = new ActividadRealizada();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        ActividadRealizada resultadoObtenido = actividadDaoImpl.getActividadRealizadaByIdActividadRealizada(1);
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba getActividadRealizadaByIdActividadRealizada ");
    }
    
}
