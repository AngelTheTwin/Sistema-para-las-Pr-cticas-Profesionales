/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Coordinador;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CoordinadorDaoImplTest {
    static Coordinador coordinador;
    static CoordinadorDaoImpl coordinadorDaoImpl;
    static List<Coordinador> coordinadoresDePrueba;
    
    public CoordinadorDaoImplTest() {
    }
    
    @BeforeClass
    public static void prepararElEntornoDePrueba(){
        coordinadoresDePrueba = new ArrayList<>();
        
        coordinadorDaoImpl = new CoordinadorDaoImpl();
        coordinador = new Coordinador();
        coordinador.setNumeroPersonalCoordinador("c001");
        coordinador.setNombreCoordinador("Enrique");
        coordinador.setApellidoPaternoCoordinador("Trujillo");
        coordinador.setApellidoMaternoCoordinador("Ornelas");
        coordinador.setContraseñaCoordinador("ETOc001");
        coordinador.setFechaRegistroCoordinador(null);
        coordinador.setTurnoCoordinador("Matutino");
        coordinador.setTiempoServicioCoordinador(5);
        coordinador.setEstadoCoordinador("Activo");
        coordinadorDaoImpl.saveCoordinador(coordinador);
        coordinadoresDePrueba.add(coordinador);
        
        coordinadorDaoImpl = new CoordinadorDaoImpl();
        coordinador = new Coordinador();
        coordinador.setNumeroPersonalCoordinador("c002");
        coordinador.setNombreCoordinador("José");
        coordinador.setApellidoPaternoCoordinador("Martínez");
        coordinador.setApellidoMaternoCoordinador("Rojas");
        coordinador.setContraseñaCoordinador("8245JMR");
        coordinador.setFechaRegistroCoordinador(null);
        coordinador.setTurnoCoordinador("Matutino");
        coordinador.setTiempoServicioCoordinador(5);
        coordinador.setEstadoCoordinador("Activo");
        coordinadorDaoImpl.saveCoordinador(coordinador);
        coordinadoresDePrueba.add(coordinador);
    }
    
    @AfterClass
    public static void cerrarEntornoDePruebas(){
        coordinadoresDePrueba.forEach((coordinadorDePrueba) -> {
            coordinadorDaoImpl = new CoordinadorDaoImpl();
            coordinadorDaoImpl.deleteCoordinador(coordinadorDePrueba);
        });
    }
    
    @Before
    public void antesDeCadaPrueba(){
        coordinadorDaoImpl = new CoordinadorDaoImpl();
    }
    
    @org.junit.Test
    public void testGetAllCoordinadores() {
        System.out.println("getAllCoordinadores");
        int resultadoEsperado = 1;
        List<Coordinador> resultadoLista = coordinadorDaoImpl.getAllCoordinadores();
        int resultadoObtenido = resultadoLista.size();
        assertEquals("Prueba obtener todos los Coordinadores",resultadoEsperado, resultadoObtenido);
        
    }

    @org.junit.Test
    public void testSaveCoordinador() {
        System.out.println("saveCoordinador");
        coordinadorDaoImpl.saveCoordinador(coordinador);
        
    }
    @org.junit.Test
    public void testGetCoordinadorByNumEmpleado() {
        System.out.println("getCoordinadorByNumEmpleado");
        String numeroEmpleado = "c001";
        Coordinador resultadoCoordinador = coordinadorDaoImpl.getCoordinadorByNumEmpleado(numeroEmpleado);
        String resultadoObtenido = resultadoCoordinador.getNumeroPersonalCoordinador();
        assertEquals(numeroEmpleado, resultadoObtenido);
    }
    
    @org.junit.Test
    public void testDeleteCoordinador() {
        System.out.println("deleteCoordinador");
        coordinadorDaoImpl.deleteCoordinador(coordinador);
    }
}
