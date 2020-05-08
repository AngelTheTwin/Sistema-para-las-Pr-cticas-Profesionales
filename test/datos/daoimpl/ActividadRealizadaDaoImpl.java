/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package Datos.DaoImpl;

import datos.dao.ActividadRealizadaDao;
import datos.ConexionMySQL;
import entidades.ActividadRealizada;
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
 * @author dagam
 */
public class ActividadRealizadaDaoImpl implements ActividadRealizadaDao{
    private final ConexionMySQL conexion;
    private List<ActividadRealizada> actividadesRealizadas;
    private ResultSet resultadoConsulta;
    
    public ActividadRealizadaDaoImpl(){
        conexion = new ConexionMySQL();
    }
    @Override
    public List<ActividadRealizada> getAllActividadesRealizadas() {
        ActividadRealizada actividadRealizada;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from ActividadRealizada";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                actividadRealizada = new ActividadRealizada();
                actividadRealizada.setIdActividadRealizada(resultadoConsulta.getString("idActividadRealizada"));
                actividadRealizada.setArchivoActividad((File)resultadoConsulta.getObject("archivoActividad"));
                actividadesRealizadas.add(actividadRealizada);
            }
        } catch (SQLException excepcion) {
            Logger.getLogger(ActividadRealizadaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }
        return actividadesRealizadas;

    }
    
   
    public void saveActividadRealizada(ActividadRealizada actividadRealizada) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO ActividadRealizdada (archivoActividadRealizada)" + "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, actividadRealizada.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ActividadRealizadaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        actividadesRealizadas.add(actividadRealizada);
    }
    
    
    public void deleteActividadRealizada(ActividadRealizada actividadRealizada) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM ActividadRealizada WERE idActividadRealizada = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, actividadRealizada.getIdActividadRealizada());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ActividadRealizadaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        actividadesRealizadas.remove(actividadRealizada);
    }

    
    public ActividadRealizada getActividadRealizadaByIdActividadRealizada(String idActividadRealizada) {
        ActividadRealizada actividadRealizada = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from ActividadRealizada where idActividadRealizada=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idActividadRealizada);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                actividadRealizada = new ActividadRealizada();
                actividadRealizada.setIdActividadRealizada(resultadoConsulta.getString("idActividadRealizada"));
                actividadRealizada.setArchivoActividad((File)resultadoConsulta.getObject("archivoActividad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRealizadaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actividadRealizada;
    }
}   
