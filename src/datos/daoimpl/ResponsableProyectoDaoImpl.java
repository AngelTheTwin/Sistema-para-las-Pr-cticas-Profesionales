/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.ResponsableProyectoDao;
import datos.ConexionMySQL;
import entidades.ResponsableProyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors dagam & Damian_Mendoza
 */
public class ResponsableProyectoDaoImpl implements ResponsableProyectoDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public ResponsableProyectoDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public ResponsableProyecto getResponsableProyectoByIdResponsableProyecto(String idResponsableProyecto) {
        ResponsableProyecto responsableProyecto = new ResponsableProyecto();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from ResponsableProyecto where idResponsableRroyecto=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idResponsableProyecto);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                responsableProyecto = new ResponsableProyecto();
                responsableProyecto.setIdResponsableProyecto(resultadoConsulta.getString("responsableProyecto"));
                responsableProyecto.setNombreResponsableProyecto(resultadoConsulta.getString("nombreResponsableProyecto"));
                responsableProyecto.setApellidoPaternoResponsableProyecto(resultadoConsulta.getString("apellidoPaternoResponsableProyecto"));
                responsableProyecto.setApellidoMaternoResponsableProyecto(resultadoConsulta.getString("apellidoMaternoResponsableProyecto"));
                responsableProyecto.setEmailResponsableProyecto(resultadoConsulta.getString("emailResponsableProyecto")); 
                responsableProyecto.setTelefonoResponsableProyecto(resultadoConsulta.getString("telefonoResponsableProyecto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responsableProyecto;
    }

    @Override
    public void saveResponsableProyecto(ResponsableProyecto responsableProyecto) {
        try(Connection conectar = conexion.obtenerConexion()) {
            String consultaSQL = "INSERT INTO ResponsableProyecto (ResponsableProyecto, "
                    + "NombreResponsableProyecto, ApellidoPaternoResponsableProyecto, "
                    + "ApellidoMaternoResponsableProyecto, EmailResponsableProyecto, "
                    + "TelefonoResponsableProyecto)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, responsableProyecto.getIdResponsableProyecto());
            sentencia.setString(2, responsableProyecto.getNombreResponsableProyecto());
            sentencia.setString(3, responsableProyecto.getApellidoPaternoResponsableProyecto());
            sentencia.setString(4, responsableProyecto.getApellidoMaternoResponsableProyecto());
            sentencia.setString(5, responsableProyecto.getEmailResponsableProyecto());
            sentencia.setString(6, responsableProyecto.getTelefonoResponsableProyecto());
            
            sentencia.execute();
            sentencia.close();
        } catch (SQLException excepcion) {
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }
    }

    @Override
    public void deleteResponsableProyecto(ResponsableProyecto responsableProyecto) {
          try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM WHERE IdResponsableProyecto = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, responsableProyecto.getIdResponsableProyecto());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ResponsableProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public List<ResponsableProyecto> getAllidResponsableProyectos() {
        ResponsableProyecto responsableProyecto;
        List<ResponsableProyecto> responsablesProyecto = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Proyecto";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                responsableProyecto = new ResponsableProyecto();
                responsableProyecto.setIdResponsableProyecto(resultadoConsulta.getString("idResponsableProyecto"));
                responsableProyecto.setNombreResponsableProyecto(resultadoConsulta.getString("nombreResponsableProyecto"));
                responsableProyecto.setApellidoPaternoResponsableProyecto(resultadoConsulta.getString("apellidoPaternoResponsableProyecto"));
                responsableProyecto.setApellidoMaternoResponsableProyecto(resultadoConsulta.getString("apellidoMaternoResponsableProyecto"));
                responsableProyecto.setEmailResponsableProyecto(resultadoConsulta.getString("emailResponsableProyecto"));
                responsableProyecto.setTelefonoResponsableProyecto(resultadoConsulta.getString("telefonoResponsableProyecto"));
                responsablesProyecto.add(responsableProyecto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responsablesProyecto;
    }
}
