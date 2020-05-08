/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.ResponsableProyecto;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Damian_Mendoza
 */
public class ResponsableProyectoDaoImplTest {
    
    public ResponsableProyectoDaoImplTest() {
    }

    @org.junit.Test
    public void testGetResponsableProyectoByIdResponsableProyecto() {
        System.out.println("getResponsableProyectoByIdResponsableProyecto");
        String idResponsableProyecto = "rp015";
        ResponsableProyectoDaoImpl instancia = new ResponsableProyectoDaoImpl();
        ResponsableProyecto responsableProyecto = instancia.getResponsableProyectoByIdResponsableProyecto(idResponsableProyecto);
        String resultadoObtenido = responsableProyecto.getIdResponsableProyecto();
         assertEquals("Prueba obtener responsable de proyecto by IdResponsableProyecto",idResponsableProyecto, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveResponsableProyecto() {
        System.out.println("saveResponsableProyecto");
        ResponsableProyecto responsableProyecto = null;
        responsableProyecto.setIdResponsableProyecto("rp015");
        responsableProyecto.setNombreResponsableProyecto("Carlos");
        responsableProyecto.setApellidoPaternoResponsableProyecto("Arriaga");
        responsableProyecto.setApellidoMaternoResponsableProyecto("Lopez");
        responsableProyecto.setEmailResponsableProyecto("CAL@gmail.com");
        responsableProyecto.setTelefonoResponsableProyecto("8347546");
        ResponsableProyectoDaoImpl instancia = new ResponsableProyectoDaoImpl();
        instancia.saveResponsableProyecto(responsableProyecto);
    }

    @org.junit.Test
    public void testDeleteResponsableProyecto() {
        System.out.println("deleteResponsableProyecto");
        ResponsableProyecto responsableProyecto = null;
        responsableProyecto.setIdResponsableProyecto("rp015");
        ResponsableProyectoDaoImpl instancia = new ResponsableProyectoDaoImpl();
        instancia.deleteResponsableProyecto(responsableProyecto);
    }

    @org.junit.Test
    public void testGetAllidResponsableProyectos() {
        System.out.println("getAllidResponsableProyectos");
        ResponsableProyectoDaoImpl instancia = new ResponsableProyectoDaoImpl();
        int resultadoEsperado = 4;
        List<ResponsableProyecto> responsableProyectos = instancia.getAllidResponsableProyectos();
        int resultadoObtenido = responsableProyectos.size();
         assertEquals("Prueba obtener todos los Responsables de proyectos",resultadoEsperado, resultadoObtenido);
    }
    
}
