/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Profesor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DamianMendoza
 */
public class ProfesorDaoImplTest {
    
    public ProfesorDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllProfesores() {
        System.out.println("getAllProfesores");
        ProfesorDaoImpl instancia = new ProfesorDaoImpl();
        int resultadoEsperado = 3;
        List<Profesor> profesores = instancia.getAllProfesores();
        int resultadoObtenido = profesores.size();
         assertEquals("Prueba obtener todos los Profesore",resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetProfesorByNumEmpleado() {
        System.out.println("getProfesorByNumEmpleado");
        String numeroPersonalProfesor = "p117";
        ProfesorDaoImpl instancia = new ProfesorDaoImpl();
        Profesor profesor = instancia.getProfesorByNumEmpleado(numeroPersonalProfesor);
        String resultadoObtenido = profesor.getNumeroPersonalProfesor();
         assertEquals("Prueba obtener Profesor by NumEmpleado",numeroPersonalProfesor, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveProfesor() {
        System.out.println("saveProfesor");
        Profesor profesor = null;
        profesor.setNumeroPersonalProfesor("p117");
        profesor.setNombreProfesor("Alejandro");
        profesor.setApellidoPaternoProfesor("Garcia");
        profesor.setApellidoMaternoProfesor("Martinez");
        profesor.setTurnoProfesor("Mixto");
        profesor.setContraseñaProfesor("AGMp117");
        profesor.setEstadoProfesor("Xalapa");
        profesor.setFechaRegistroProfesor(null);
        profesor.setTiempoServicioProfesor(9);
        ProfesorDaoImpl instancia = new ProfesorDaoImpl();
        instancia.saveProfesor(profesor);
    }

    @org.junit.Test
    public void testDeleteProfesor() {
        System.out.println("deleteProfesor");
        Profesor profesor = null;
        profesor.setNumeroPersonalProfesor("p117");
        ProfesorDaoImpl instancia = new ProfesorDaoImpl();
        instancia.deleteProfesor(profesor);
    }
    
}
