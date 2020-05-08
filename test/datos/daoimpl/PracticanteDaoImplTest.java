/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Practicante;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Damian_Mendoza
 */
public class PracticanteDaoImplTest {
    
    public PracticanteDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllPracticantes() {
        System.out.println("getAllPracticantes");
        PracticanteDaoImpl instancia = new PracticanteDaoImpl();
        int resultadoEsperado = 5;
        List<Practicante> practicantes = instancia.getAllPracticantes();
        int resultadoObtenido = practicantes.size();
         assertEquals("Prueba obtener todos los Practicantes",resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetPracticanteByMatricula() {
        System.out.println("getPracticanteByMatricula");
        String matricula = "s18012133";
        PracticanteDaoImpl instancia = new PracticanteDaoImpl();
        Practicante practicante = instancia.getPracticanteByMatricula(matricula);
        String resultadoObtenido = practicante.getMatricula();
         assertEquals("Prueba obtener Practicante by matricula",matricula, resultadoObtenido);
        
    }

    @org.junit.Test
    public void testSavePracticante() {
        System.out.println("savePracticante");
        Practicante practicante = null;
        practicante.setMatricula("s18012133");
        practicante.setNombrePracticante("Jose Damian");
        practicante.setApellidoPaternoPracticante("Mendoza");
        practicante.setApellidoMaternoPracticante("Carmona");
        practicante.setTurnoPracticante("Vespertino");
        practicante.setContraseñaPracticante("JDMCzS180");
        practicante.setGeneroPracticante("Masculino");
        practicante.setPeriodoPracticante(7);
        practicante.setEstadoPracticante("Xalapa");
        practicante.setCalificacion(8);
        PracticanteDaoImpl instancia = new PracticanteDaoImpl();
        instancia.savePracticante(practicante);
    }

    @org.junit.Test
    public void testDeletePracticante() {
        System.out.println("deletePracticante");
        Practicante practicante = null;
        practicante.setMatricula("s18012133");
        PracticanteDaoImpl instancia = new PracticanteDaoImpl();
        instancia.deletePracticante(practicante);
    }
    
}
