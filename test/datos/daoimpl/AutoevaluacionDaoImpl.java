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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.PDF;

/**
 *
 * @author angel
 */
public class AutoevaluacionDaoImpl implements AutoevaluacionDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public AutoevaluacionDaoImpl (){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Autoevaluacion> getAllAutoevaluaciones() {
        Autoevaluacion autoevaluacion;
        List<Autoevaluacion> autoevaluaciones = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Autoevaluacion";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                autoevaluacion = new Autoevaluacion();
                int idAutoevaluacion = resultadoConsulta.getInt("idAutoevaluacion");
                autoevaluacion.setIdAutoevaluacion(idAutoevaluacion);
                Blob archivoAutoevaluacion = resultadoConsulta.getBlob("archivoAutoevaluacion");
                autoevaluacion.setArchivoAutoevaluacion(PDF.byteAPdf(archivoAutoevaluacion, "Autoevaluacion" + idAutoevaluacion));
                autoevaluaciones.add(autoevaluacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autoevaluaciones;
    }

    @Override
    public Autoevaluacion getAutoevaluacionByIdAutoevaluacion(int idAutoevaluacion) {
        Autoevaluacion autoevaluacion = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Autoevaluacion where idAutoevaluacion=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setInt(1, idAutoevaluacion);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                autoevaluacion = new Autoevaluacion();
                autoevaluacion.setIdAutoevaluacion(resultadoConsulta.getInt("idAutoevaluacion"));
                Blob archivoAutoevaluacion = resultadoConsulta.getBlob("archivoAutoevaluacion");
                autoevaluacion.setArchivoAutoevaluacion(PDF.byteAPdf(archivoAutoevaluacion, "Autoevaluacion" + idAutoevaluacion));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autoevaluacion;
    }

    @Override
    public void saveAutoevaluacion(Autoevaluacion autoevaluacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Autoevaluacion (archivoAutoevaluacion)" +
                    "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, autoevaluacion.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deleteAutoevaluacion(Autoevaluacion autoevaluacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Autoevaluacion WhERE idAutoevaluacion = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setInt(1, autoevaluacion.getIdAutoevaluacion());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(AutoevaluacionDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}