/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Proyecto;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Damian_Mendoza
 */
public class ProyectoDaoImplTest {
    
    public ProyectoDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllProyectos() {
        System.out.println("getAllProyectos");
        ProyectoDaoImpl instancia = new ProyectoDaoImpl();
        int resultadoEsperado = 4;
        List<Proyecto> proyectos = instancia.getAllProyectos();
        int resultadoObtenido = proyectos.size();
         assertEquals("Prueba obtener todos los Proyectos",resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetProyectoByNombreProyecto() {
        System.out.println("getProyectoByNombreProyecto");
        String nombreProyecto = "Implementacion de IA en registros de cliente";
        ProyectoDaoImpl instancia = new ProyectoDaoImpl();
        Proyecto proyecto = instancia.getProyectoByNombreProyecto(nombreProyecto);
        String resultadoObtenido = proyecto.getNombreProyecto();
         assertEquals("Prueba obtener proyecto by NombreProyecto",nombreProyecto, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveProyecto() {
        System.out.println("saveProyecto");
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreProyecto("Implementacion de IA en registros de cliente");
        proyecto.setDescripcionProyecto("Se automatizaran los registros de cliente con IA");
        proyecto.setRecursoProyecto("Laptop, internet, sistema legado");
        proyecto.setDuracionProyecto(200);
        proyecto.setObjetivoProyecto("Automatizar proceso de registro de clientes");
        proyecto.setMetodologiaProyecto("Todas");
        ProyectoDaoImpl instancia = new ProyectoDaoImpl();
        instancia.saveProyecto(proyecto);
    }

    @org.junit.Test
    public void testDeleteProyecto() {
        System.out.println("deleteProyecto");
        Proyecto proyecto = null;
        proyecto.setNombreProyecto("Implementacion de IA en registros de cliente");
        ProyectoDaoImpl instancia = new ProyectoDaoImpl();
        instancia.deleteProyecto(proyecto);
    }
    
}
