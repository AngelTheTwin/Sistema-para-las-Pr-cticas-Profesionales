/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.ProfesorDao;
import datos.ConexionMySQL;
import entidades.Profesor;
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
 * @author angel
 */
public class ProfesorDaoImpl implements ProfesorDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public ProfesorDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Profesor> getAllProfesores() {
        Profesor profesor;
        List<Profesor> profesores = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Profesor";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                profesor = new Profesor();
                profesor.setNumeroPersonalProfesor(resultadoConsulta.getString("numeroPersonalProfesor"));
                profesor.setNombreProfesor(resultadoConsulta.getString("nombreProfesor"));
                profesor.setApellidoPaternoProfesor(resultadoConsulta.getString("apellidoPaternoProfesor"));
                profesor.setApellidoMaternoProfesor(resultadoConsulta.getString("apellidoMaternoProfesor"));
                profesor.setTurnoProfesor(resultadoConsulta.getString("turnoProfesor"));
                profesor.setContraseñaProfesor(resultadoConsulta.getString("contraseñaProfesor"));
                profesor.setEstadoProfesor(resultadoConsulta.getString("estadoProfesor"));
                
                profesores.add(profesor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }

    @Override
    public Profesor getProfesorByNumEmpleado(String numeroPersonalProfesor) {
        Profesor profesor = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Profesor where noPersonal=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, numeroPersonalProfesor);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                profesor = new Profesor();
                profesor.setNumeroPersonalProfesor(resultadoConsulta.getString("numeroPersonalProfesor"));
                profesor.setNombreProfesor(resultadoConsulta.getString("nombreProfesor"));
                profesor.setApellidoPaternoProfesor(resultadoConsulta.getString("apellidoPaternoProfesor"));
                profesor.setApellidoMaternoProfesor(resultadoConsulta.getString("apellidoMaternoProfesor"));
                profesor.setTurnoProfesor(resultadoConsulta.getString("turnoProfesor"));
                profesor.setContraseñaProfesor(resultadoConsulta.getString("contraseñaProfesor"));
                profesor.setEstadoProfesor(resultadoConsulta.getString("estadoProfesor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesor;
    }

    @Override
    public void saveProfesor(Profesor profesor) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Profesor (NumeroPersonalProfesor, NombreProfesor,"
                + "ApellidoPaternoProfesor, ApellidoMaternoProfesor, TurnoProfesor, ContraseñaProfesor, EstadoProfesor)" + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, profesor.getNumeroPersonalProfesor());
            sentencia.setString(2, profesor.getNombreProfesor());
            sentencia.setString(3, profesor.getApellidoPaternoProfesor());
            sentencia.setString(4, profesor.getApellidoMaternoProfesor());
            sentencia.setString(5, profesor.getTurnoProfesor());
            sentencia.setString(6, profesor.getContraseñaProfesor());
            sentencia.setString(7, profesor.getEstadoProfesor());

            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }
    @Override
    
    public void deleteProfesor(Profesor profesor) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM WHERE NumeroPersonalProfesor = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, profesor.getNumeroPersonalProfesor());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ProfesorDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}