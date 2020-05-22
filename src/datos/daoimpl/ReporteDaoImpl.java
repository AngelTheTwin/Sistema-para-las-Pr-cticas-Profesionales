/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.ReporteDao;
import datos.ConexionMySQL;
import entidades.Reporte;
import java.io.File;
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
 * @author dagam
 */
public class ReporteDaoImpl implements ReporteDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public ReporteDaoImpl(){
        conexion = new ConexionMySQL();
    }
   
    @Override
    public List<Reporte> getAllReportes() {
       Reporte reporte;
        List<Reporte> reportes = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Reporte";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                reporte = new Reporte();
                reporte.setIdReporte(resultadoConsulta.getString("idReporte"));
                reporte.setArchivoReporte((File)resultadoConsulta.getObject("archivoReporte"));
                reporte.setFechaEntregaReporte(resultadoConsulta.getDate("fechaEntregaReporte"));
                reportes.add(reporte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportes;
    }

    @Override
    public Reporte getReporteByIdReporte(String idReporte) {
        Reporte reporte = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Reporte where idReporte=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idReporte);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                reporte = new Reporte();
                reporte.setIdReporte(resultadoConsulta.getString("idReporte"));
                reporte.setArchivoReporte((File)resultadoConsulta.getObject("archivoReporte"));
                reporte.setFechaEntregaReporte(resultadoConsulta.getDate("fechaEntregaReporte"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reporte;
    }

    @Override
    public void saveReporte(Reporte reporte) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Reporte (archivoHorario)" + "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, reporte.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ReporteDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deleteReporte(Reporte reporte) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Reporte WERE idReporte = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, reporte.getIdReporte());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ReporteDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}
