/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.CoordinadorDao;
import datos.ConexionMySQL;
import entidades.Coordinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class CoordinadorDaoImpl implements CoordinadorDao{
    private final ConexionMySQL conexion;
    private List<Coordinador> coordinadores;
    private ResultSet resultadoConsulta;
    
    public CoordinadorDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Coordinador> getAllCoordinadores() {
        Coordinador coordinador;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Coordinador";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                coordinador = new Coordinador();
                coordinador.setNumeroPersonalCoordinador(resultadoConsulta.getString("numeroPersonalCoordinador"));
                coordinador.setNombreCoordinador(resultadoConsulta.getString("nombreCoordinador"));
                coordinador.setApellidoPaternoCoordinador(resultadoConsulta.getString("apellidoPaternoCoordinador"));
                coordinador.setApellidoMaternoCoordinador(resultadoConsulta.getString("apellidoMaternoCoordinador"));
                coordinador.setTurnoCoordinador(resultadoConsulta.getString("turnoCoordinador"));
                coordinador.setContraseñaCoordinador(resultadoConsulta.getString("contraseñaCoordinador"));
                coordinador.setEstadoCoordinador(resultadoConsulta.getString("estadoCoordinador"));
                coordinadores.add(coordinador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.desconectar();
        }
        return coordinadores;
    }

    @Override
    public void saveCoordinador(Coordinador coordinador) {
        
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Coordinador (NumeroPersonalCoordinador, NombreCoordinador,"
                + "ApellidoPaternoCoordinador, ApellidoMaternoCoordinador, ContraseñaCoordinador,"
                + "TurnoCoordinador, EstadoCoordinador)" + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, coordinador.getNumeroPersonalCoordinador());
            sentencia.setString(2, coordinador.getNombreCoordinador());
            sentencia.setString(3, coordinador.getApellidoPaternoCoordinador());
            sentencia.setString(4, coordinador.getApellidoMaternoCoordinador());
            sentencia.setString(5, coordinador.getContraseñaCoordinador());
            sentencia.setString(6, coordinador.getTurnoCoordinador());
            sentencia.setString(7, coordinador.getEstadoCoordinador());

            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
        //coordinadores.add(coordinador);
    }

    @Override
    public void deleteCoordinador(Coordinador coordinador) {
       try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Coordinador WHERE NumeroPersonalCoordinador = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, coordinador.getNumeroPersonalCoordinador());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        //coordinadores.remove(coordinador);
    }

    @Override
    public Coordinador getCoordinadorByNumEmpleado(String noEmpleado){
        Coordinador coordinador = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Coordinador where numeroPersonalCoordinador=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, noEmpleado);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                coordinador = new Coordinador();
                coordinador.setNumeroPersonalCoordinador(resultadoConsulta.getString("numeroPersonalCoordinador"));
                coordinador.setNombreCoordinador(resultadoConsulta.getString("nombreCoordinador"));
                coordinador.setApellidoPaternoCoordinador(resultadoConsulta.getString("apellidoPaternoCoordinador"));
                coordinador.setApellidoMaternoCoordinador(resultadoConsulta.getString("apellidoMaternoCoordinador"));
                coordinador.setTurnoCoordinador(resultadoConsulta.getString("turnoCoordinador"));
                coordinador.setContraseñaCoordinador(resultadoConsulta.getString("contraseñaCoordinador"));
                coordinador.setEstadoCoordinador(resultadoConsulta.getString("estadoCoordinador"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coordinador;
    }
}
