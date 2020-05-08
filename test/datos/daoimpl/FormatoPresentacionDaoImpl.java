/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.ConexionMySQL;
import datos.dao.FormatoPresentacionDao;
import entidades.FormatoPresentacion;
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
public class FormatoPresentacionDaoImpl implements FormatoPresentacionDao{
    private final ConexionMySQL conexion;
    private List<FormatoPresentacion> formatosPresentacion;
    private ResultSet resultadoConsulta;
    
    public FormatoPresentacionDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<FormatoPresentacion> getAllPresentaciones() {
        FormatoPresentacion formatoPresentacion;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from FormatoPresentacion";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                formatoPresentacion = new FormatoPresentacion();
                formatoPresentacion.setIdFormatoPresentacion(resultadoConsulta.getString("idFormatoPresentacion"));
                formatoPresentacion.setArchivoFormatoPresentacion((File)resultadoConsulta.getObject("archivoFormatoPresentacion"));
                formatosPresentacion.add(formatoPresentacion);
            }
        } catch (SQLException excepcion) {
            Logger.getLogger(FormatoPresentacion.class.getName()).log(Level.SEVERE, null, excepcion);
        }
        return formatosPresentacion;
    }

    @Override
    public FormatoPresentacion getFormatoPresentacionByIdFormato(String idFormato) {
        FormatoPresentacion formatoPresentacion = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * From FormatoPresentacion where idFormato=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idFormato);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                formatoPresentacion = new FormatoPresentacion();
                formatoPresentacion.setIdFormatoPresentacion(resultadoConsulta.getString("idFormatoPresentacion"));
                formatoPresentacion.setArchivoFormatoPresentacion((File)resultadoConsulta.getObject("archivoFormatoPresentacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormatoPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatoPresentacion;
    }

    @Override
    public void saveFormatoPresentacion(FormatoPresentacion formatoPresentacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO FormatoPresentacion (archivoFormatoPresentacion)" + "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, formatoPresentacion.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(FormatoPresentacionDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        formatosPresentacion.add(formatoPresentacion);
    }

    @Override
    public void deleteFormatoPresentacion(FormatoPresentacion formatoPresentacion) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM FORMATOPRESENTACION WERE idFormatoPreseentacion = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, formatoPresentacion.getIdFormatoPresentacion());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(FormatoPresentacionDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        formatosPresentacion.remove(formatoPresentacion);
    }
}
