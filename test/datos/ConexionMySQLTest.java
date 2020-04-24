/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ConexionMySQLTest {
    private final ConexionMySQL conexion;
    
    public ConexionMySQLTest() {
        conexion = new ConexionMySQL();
    }

    @org.junit.Test
    public void testObtenerConexion() {
        System.out.println("obtenerConexion");
        Connection coneccion = conexion.obtenerConexion();
        assertNotNull(coneccion);
    }

    @org.junit.Test
    public void testDesconectar() {
        System.out.println("desconectar");
        Connection coneccion = conexion.obtenerConexion();
       assertTrue(coneccion.isClosed());
    }
    
}
