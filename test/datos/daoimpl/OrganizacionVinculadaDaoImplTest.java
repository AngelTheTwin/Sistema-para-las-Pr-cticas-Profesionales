/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.OrganizacionVinculada;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Damian_Mendoza
 */
public class OrganizacionVinculadaDaoImplTest {
    
    public OrganizacionVinculadaDaoImplTest() {
    }

    @org.junit.Test
    public void testGetAllOrganizacionesVinculadas() {
        System.out.println("getAllOrganizacionesVinculadas");
        OrganizacionVinculadaDaoImpl instancia = new OrganizacionVinculadaDaoImpl();
        int resultadoEsperado = 3;
        List<OrganizacionVinculada> organizacionVinculada = instancia.getAllOrganizacionesVinculadas();
        int resultadoObtenido = organizacionVinculada.size();
         assertEquals("Prueba obtener todos las organizaciones vinculadas",resultadoEsperado, resultadoObtenido);
    }

    @org.junit.Test
    public void testGetOrganizacionVinculadaByNombreOrganizacion() {
        System.out.println("getOrganizacionVinculadaByNombreOrganizacion");
        String nombreOrganizacion = "IBM";
        OrganizacionVinculadaDaoImpl instancia = new OrganizacionVinculadaDaoImpl();
        OrganizacionVinculada organizacionVinculada = instancia.getOrganizacionVinculadaByNombreOrganizacion(nombreOrganizacion);
        String resultadoObtenido = organizacionVinculada.getNombreOrganizacion();
         assertEquals("Prueba obtener organizacion vinculada by nombreOrganizacion",nombreOrganizacion, resultadoObtenido);
    }

    @org.junit.Test
    public void testSaveOrganizacionVinculada() {
        System.out.println("saveOrganizacionVinculada");
        OrganizacionVinculada organizacionVinculada = new OrganizacionVinculada();
        organizacionVinculada.setNombreOrganizacion("IBM");
        organizacionVinculada.setDireccion("Leon Tolstoi #14");
        organizacionVinculada.setCiudad("ZMG");
        organizacionVinculada.setEstado("Jalisco");
        organizacionVinculada.setSector("Centro");
        organizacionVinculada.setTelefonoOrganizacion("+3542345345");
        organizacionVinculada.setEmailOrganizacion("rh@ibm.com");
        OrganizacionVinculadaDaoImpl instancia = new OrganizacionVinculadaDaoImpl();
        instancia.saveOrganizacionVinculada(organizacionVinculada);
    }

    @org.junit.Test
    public void testDeleteOrganizacionVinculada() {
        System.out.println("deleteOrganizacionVinculada");
        OrganizacionVinculada organizacionVinculada = new OrganizacionVinculada();
        organizacionVinculada.setNombreOrganizacion("IBM");
        OrganizacionVinculadaDaoImpl instancia = new OrganizacionVinculadaDaoImpl();
        instancia.deleteOrganizacionVinculada(organizacionVinculada);
    }
    
}
