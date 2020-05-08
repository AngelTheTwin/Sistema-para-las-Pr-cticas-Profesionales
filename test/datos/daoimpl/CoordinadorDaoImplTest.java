/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Coordinador;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CoordinadorDaoImplTest {
    
    public CoordinadorDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllCoordinadores() {
        System.out.println("getAllCoordinadores");
        CoordinadorDaoImpl instance = new CoordinadorDaoImpl();
        int resultadoEsperado = 5;
        List<Coordinador> resultadoLista = instance.getAllCoordinadores();
        int resultadoObtenido = resultadoLista.size();
        assertEquals("Prueba obtener todos los Coordinadores",resultadoEsperado, resultadoObtenido);
        
    }

    @org.junit.Test
    public void testSaveCoordinador() {
        System.out.println("saveCoordinador");
        Coordinador coordinador = new Coordinador();
        coordinador.setNumeroPersonalCoordinador("c001");
        coordinador.setNombreCoordinador("Enrique");
        coordinador.setApellidoPaternoCoordinador("Trujillo");
        coordinador.setApellidoMaternoCoordinador("Ornelas");
        coordinador.setContraseñaCoordinador("ETOc001");
        coordinador.setFechaRegistroCoordinador(null);
        coordinador.setTurnoCoordinador("Matutino");
        coordinador.setTiempoServicioCoordinador(5);
        coordinador.setEstadoCoordinador("Activo");
        CoordinadorDaoImpl instance = new CoordinadorDaoImpl();
        instance.saveCoordinador(coordinador);
        
    }

    @org.junit.Test
    public void testDeleteCoordinador() {
        System.out.println("deleteCoordinador");
        Coordinador coordinador = new Coordinador();
        coordinador.setNumeroPersonalCoordinador("c001");
        CoordinadorDaoImpl instance = new CoordinadorDaoImpl();
        
        instance.deleteCoordinador(coordinador);
    }

    @org.junit.Test
    public void testGetCoordinadorByNumEmpleado() {
        System.out.println("getCoordinadorByNumEmpleado");
        String numeroEmpleado = "c001";
        CoordinadorDaoImpl instancia = new CoordinadorDaoImpl();
        Coordinador resultadoCoordinador = instancia.getCoordinadorByNumEmpleado(numeroEmpleado);
        String resultadoObtenido = resultadoCoordinador.getNumeroPersonalCoordinador();
        assertEquals(numeroEmpleado, resultadoObtenido);
    }
    
}
