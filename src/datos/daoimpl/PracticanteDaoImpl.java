/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.PracticanteDao;
import datos.ConexionMySQL;
import entidades.Practicante;
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
public class PracticanteDaoImpl implements PracticanteDao {
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public PracticanteDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Practicante> getAllPracticantes() {
        Practicante practicante;
        List<Practicante> practicantes = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Practicante";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                practicante = new Practicante();
                practicante.setMatricula(resultadoConsulta.getString("matricula"));
                practicante.setNombrePracticante(resultadoConsulta.getString("nombrePracticante"));
                practicante.setApellidoPaternoPracticante(resultadoConsulta.getString("apellidoPaternoPracticante"));
                practicante.setApellidoMaternoPracticante(resultadoConsulta.getString("apellidoMaternoPracticante"));
                practicante.setTurnoPracticante(resultadoConsulta.getString("turnoPracticante"));
                practicante.setContraseñaPracticante(resultadoConsulta.getString("contraseñaPracticante"));
                practicante.setGeneroPracticante(resultadoConsulta.getString("generoPracticante"));
                practicante.setPeriodoPracticante(resultadoConsulta.getInt("periodoPracticante"));
                practicante.setEstadoPracticante(resultadoConsulta.getString("estadoPracticante"));
                practicante.setCalificacion(resultadoConsulta.getInt("calificacion"));
                practicantes.add(practicante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PracticanteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return practicantes;
    }

    @Override
    public Practicante getPracticanteByMatricula(String matricula) {
        Practicante practicante = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Practicante where matricula=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, matricula);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                practicante = new Practicante();
                practicante.setMatricula(resultadoConsulta.getString("matricula"));
                practicante.setNombrePracticante(resultadoConsulta.getString("nombrePracticante"));
                practicante.setApellidoPaternoPracticante(resultadoConsulta.getString("apellidoPaternoPracticante"));
                practicante.setApellidoMaternoPracticante(resultadoConsulta.getString("apellidoMaternoPracticante"));
                practicante.setTurnoPracticante(resultadoConsulta.getString("turnoPracticante"));
                practicante.setContraseñaPracticante(resultadoConsulta.getString("contraseñaPracticante"));
                practicante.setGeneroPracticante(resultadoConsulta.getString("generoPracticante"));
                practicante.setPeriodoPracticante(resultadoConsulta.getInt("periodoPracticante"));
                practicante.setEstadoPracticante(resultadoConsulta.getString("estadoPracticante"));
                practicante.setCalificacion(resultadoConsulta.getInt("calificacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PracticanteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return practicante;
    }

    @Override
    public void savePracticante(Practicante practicante) {
        
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Practicante (MatriculaPracticante, NombrePracticante, "
               + "ApellidoPaternoPracticante, ApellidoMaternoPracticante, TurnoPracticante, "
               + "ContraseñaPracticante, GeneroPracticante, PeriodoPracticante, EstadoPracticante, "
               + "Calificacion)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, practicante.getMatricula());
            sentencia.setString(2, practicante.getNombrePracticante());
            sentencia.setString(3, practicante.getApellidoPaternoPracticante());
            sentencia.setString(4, practicante.getApellidoMaternoPracticante());
            sentencia.setString(5, practicante.getTurnoPracticante());
            sentencia.setString(6, practicante.getContraseñaPracticante());
            sentencia.setString(7, practicante.getGeneroPracticante());
            sentencia.setInt(8, practicante.getPeriodoPracticante());
            sentencia.setString(9, practicante.getEstadoPracticante());
            sentencia.setInt(10, practicante.getCalificacion());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deletePracticante(Practicante practicante) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM WHERE Matricula = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, practicante.getMatricula());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(PracticanteDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}
