/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.OrganizacionVinculadaDao;
import datos.ConexionMySQL;
import entidades.OrganizacionVinculada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors angel & Damian_Mendoza
 */
public class OrganizacionVinculadaDaoImpl implements OrganizacionVinculadaDao{
    
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public OrganizacionVinculadaDaoImpl(){
        conexion = new ConexionMySQL();
    }
    
    @Override
    public List<OrganizacionVinculada> getAllOrganizacionesVinculadas() {
        OrganizacionVinculada organizacionVinculada;
        List<OrganizacionVinculada> organizaciones = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from OrganizacionVinculada";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                organizacionVinculada = new OrganizacionVinculada();
                organizacionVinculada.setNombreOrganizacion(resultadoConsulta.getString("nombreOrganizacion"));
                organizacionVinculada.setDireccion(resultadoConsulta.getString("direccion"));
                organizacionVinculada.setCiudad(resultadoConsulta.getString("ciudad"));
                organizacionVinculada.setEstado(resultadoConsulta.getString("estado"));
                organizacionVinculada.setSector(resultadoConsulta.getString("sector"));
                organizacionVinculada.setTelefonoOrganizacion(resultadoConsulta.getString("telefonoOrganizacion"));
                organizacionVinculada.setEmailOrganizacion(resultadoConsulta.getString("emailOrganizacion"));
                organizaciones.add(organizacionVinculada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return organizaciones;
    }

    @Override
    public OrganizacionVinculada getOrganizacionVinculadaByNombreOrganizacion(String nombreOrganizacion) {
        OrganizacionVinculada organizacionVinculada = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from OrganizacionVinculada where nombreOrganizacion=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, nombreOrganizacion);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                organizacionVinculada = new OrganizacionVinculada();
                organizacionVinculada.setNombreOrganizacion(resultadoConsulta.getString("nombreOrganizacion"));
                organizacionVinculada.setDireccion(resultadoConsulta.getString("direccion"));
                organizacionVinculada.setCiudad(resultadoConsulta.getString("ciudad"));
                organizacionVinculada.setEstado(resultadoConsulta.getString("estado"));
                organizacionVinculada.setSector(resultadoConsulta.getString("sector"));
                organizacionVinculada.setTelefonoOrganizacion(resultadoConsulta.getString("telefonoOrganizacion"));
                organizacionVinculada.setEmailOrganizacion(resultadoConsulta.getString("emailOrganizacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return organizacionVinculada;
    }

    @Override
    public void saveOrganizacionVinculada(OrganizacionVinculada organizacionVinculada) {
        try(Connection conectar = conexion.obtenerConexion()) {
            String consultaSQL = "INSERT INTO OrganizacionVinculada "
                    + "(NombreOrganizacion, Direccion, Ciudad, Estado, "
                    + "Sector, TelefonoOrganizacion, EmailOrganizacion)"
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, organizacionVinculada.getNombreOrganizacion());
            sentencia.setString(2, organizacionVinculada.getDireccion());
            sentencia.setString(3, organizacionVinculada.getCiudad());
            sentencia.setString(4, organizacionVinculada.getEstado());
            sentencia.setString(5, organizacionVinculada.getSector());
            sentencia.setString(6, organizacionVinculada.getTelefonoOrganizacion());
            sentencia.setString(7, organizacionVinculada.getEmailOrganizacion());
            
            sentencia.execute();
            sentencia.close();
        } catch (SQLException excepcion) {
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deleteOrganizacionVinculada(OrganizacionVinculada organizacionVinculada) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM WHERE NombreOrganizacion = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, organizacionVinculada.getNombreOrganizacion());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(OrganizacionVinculadaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}
