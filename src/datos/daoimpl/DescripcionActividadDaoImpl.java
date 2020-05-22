/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.DescripcionActividadDao;
import datos.ConexionMySQL;
import entidades.DescripcionActividad;
import java.sql.Connection;
import java.sql.Date;
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
public class DescripcionActividadDaoImpl implements DescripcionActividadDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public DescripcionActividadDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<DescripcionActividad> getAllDescripcionesActividades() {
        DescripcionActividad descripcionActividad;
        List<DescripcionActividad> descripciones = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from DescripcionActividad";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                descripcionActividad = new DescripcionActividad();
                descripcionActividad.setIdActividad(resultadoConsulta.getString("idActividad"));
                descripcionActividad.setTituloActividad(resultadoConsulta.getString("tituloActividad"));
                descripcionActividad.setDescripcionActividad(resultadoConsulta.getString("descripcionActividad"));
                descripcionActividad.setFechaEntregaActividad((Date)resultadoConsulta.getObject("fechaEntregaActividad"));
                descripciones.add(descripcionActividad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripciones;
    }

    @Override
    public DescripcionActividad getDescripcionActividadByIdActividad(String idActividad) {
        DescripcionActividad descripcionActividad = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from DescripcionActividad where idActividad=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idActividad);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                descripcionActividad = new DescripcionActividad();
                descripcionActividad.setIdActividad(resultadoConsulta.getString("idActividad"));
                descripcionActividad.setTituloActividad(resultadoConsulta.getString("tituloActividad"));
                descripcionActividad.setDescripcionActividad(resultadoConsulta.getString("descripcionActividad"));
                descripcionActividad.setFechaEntregaActividad((Date)resultadoConsulta.getObject("fechaEntregaActividad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcionActividad;
    }

    @Override
    public void saveDescripcionActividad(DescripcionActividad descripcionActividad) {
        try(Connection conectar = conexion.obtenerConexion()) {
            String consultaSQL = "INSERT INTO DescripcionActividad (IdActividad, " 
                    + "TituloActividad, DescripcionActividad, FechaEntregaActividad)" 
                    + "VALUES(?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, descripcionActividad.getIdActividad());
            sentencia.setString(2, descripcionActividad.getTituloActividad());
            sentencia.setString(3, descripcionActividad.getDescripcionActividad());
            sentencia.setDate(4, descripcionActividad.getFechaEntregaActividad());
            
            sentencia.execute();
            sentencia.close();
        } catch (SQLException excepcion) {
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deleteDescripcionActividad(DescripcionActividad descripcionActividad) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM DescripcionActividad WHERE IdActividad = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, descripcionActividad.getIdActividad());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(DescripcionActividadDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);

        }finally{
            conexion.desconectar();
        }
    }
}
