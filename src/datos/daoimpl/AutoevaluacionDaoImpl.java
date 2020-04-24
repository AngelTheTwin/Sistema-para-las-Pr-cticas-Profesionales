/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.AutoevaluacionDao;
import datos.ConexionMySQL;
import entidades.Autoevaluacion;
import java.io.File;
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
public class AutoevaluacionDaoImpl implements AutoevaluacionDao{
    private final ConexionMySQL conexion;
    private List<Autoevaluacion> autoevaluaciones;
    private ResultSet resultadoConsulta;
    
    public AutoevaluacionDaoImpl (){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Autoevaluacion> getAllAutoevaluaciones() {
        Autoevaluacion autoevaluacion;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Autoevaluacion";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                autoevaluacion = new Autoevaluacion();
                autoevaluacion.setIdAutoevaluacion(resultadoConsulta.getString("idAutoevaluacion"));
                autoevaluacion.setArchivoAutoevaluacion((File)resultadoConsulta.getObject("archivoAutoevaluacion"));
                autoevaluaciones.add(autoevaluacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autoevaluaciones;
    }

    @Override
    public Autoevaluacion getAutoevaluacionByIdAutoevaluacion(String idAutoevaluacion) {
        Autoevaluacion autoevaluacion = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Autoevaluacion where idAutoevaluacion=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idAutoevaluacion);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                autoevaluacion = new Autoevaluacion();
                autoevaluacion.setIdAutoevaluacion(resultadoConsulta.getString("idAutoevaluacion"));
                autoevaluacion.setArchivoAutoevaluacion((File)resultadoConsulta.getObject("archivoAutoevaluacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autoevaluacion;
    }

    @Override
    public void saveAutoevaluacion(Autoevaluacion autoevaluacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Autoevaluacion (archivoAutoevalucacion)" +
                    "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, autoevaluacion.getIdAutoevaluacion());
            sentencia.setBytes(2, autoevaluacion.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
        autoevaluaciones.add(autoevaluacion);
    }

    @Override
    public void deleteAutoevaluacion(Autoevaluacion autoevaluacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM FORMATOPRESENTACION WERE idFormatoPreseentacion = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, autoevaluacion.getIdAutoevaluacion());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        autoevaluaciones.remove(autoevaluacion);
    }
    
    
}
