/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.DescripcionActividad;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Damian_Mendoza
 */
public class DescripcionActividadDaoImplTest {
    
    public DescripcionActividadDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllDescripcionesActividades() {
        System.out.println("getAllDescripcionesActividades");
        DescripcionActividadDaoImpl instance = new DescripcionActividadDaoImpl();
       int resultadoEsperado = 5;
        List<DescripcionActividad> resultado = instance.getAllDescripcionesActividades();
        int resultadoObtenido = resultado.size();
        assertEquals("Prueba obtener todos las descripciones de actividad",resultadoEsperado, resultadoObtenido);
      
    }

    @org.junit.Test
    public void testGetDescripcionActividadByIdActividad() {
        System.out.println("getDescripcionActividadByIdActividad");
        String idActividad = "a003";
        DescripcionActividadDaoImpl sentencia = new DescripcionActividadDaoImpl();
        DescripcionActividad descripcionActividad = sentencia.getDescripcionActividadByIdActividad(idActividad);
        String resultadoObtenido = descripcionActividad.getIdActividad();
         assertEquals("Prueba obtener descripcion de actividad by IdActividad",idActividad, resultadoObtenido);
      
    }

    @org.junit.Test
    public void testSaveDescripcionActividad() {
        System.out.println("saveDescripcionActividad");
        DescripcionActividad descripcionActividad = null;
        descripcionActividad.setIdActividad("a003");
        descripcionActividad.setTituloActividad("Entrega de tercer reporte");
        descripcionActividad.setDescripcionActividad("Se debera de entregar el archivo correspondiente al tercer reporte");
        descripcionActividad.setFechaEntregaActividad(null);
        DescripcionActividadDaoImpl sentencia = new DescripcionActividadDaoImpl();
        sentencia.saveDescripcionActividad(descripcionActividad);
       
    }

    @org.junit.Test
    public void testDeleteDescripcionActividad() {
        System.out.println("deleteDescripcionActividad");
        DescripcionActividad descripcionActividad = null;
        descripcionActividad.setIdActividad("a003");
        DescripcionActividadDaoImpl instance = new DescripcionActividadDaoImpl();
        instance.deleteDescripcionActividad(descripcionActividad);
      
    }
    
}
