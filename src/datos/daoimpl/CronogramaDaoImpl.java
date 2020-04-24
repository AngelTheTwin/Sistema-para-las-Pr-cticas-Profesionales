/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import datos.dao.CronogramaDao;
import datos.ConexionMySQL;
import entidades.Cronograma;
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
public class CronogramaDaoImpl implements CronogramaDao{
    
    private final ConexionMySQL conexion;
    private List<Cronograma> cronogramas;
    private ResultSet resultadoConsulta;
    
    public CronogramaDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Cronograma> getAllCronogramas() {
         Cronograma cronograma;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Cronograma";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                cronograma = new Cronograma();
                cronograma.setIdCronograma(resultadoConsulta.getString("idCronograma"));
                cronograma.setArchivoCronograma((File)resultadoConsulta.getObject("archivoCronograma"));
                cronogramas.add(cronograma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cronogramas;
    }

    @Override
    public Cronograma getCronogramaByIdCronograma(String idCronograma) {
        Cronograma cronograma = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Cronograma where idCronograma=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idCronograma);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                cronograma = new Cronograma();
                cronograma.setIdCronograma(resultadoConsulta.getString("idCronograma"));
                cronograma.setArchivoCronograma((File)resultadoConsulta.getObject("archivoCronograma"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cronograma;
    }

    @Override
    public void saveCronograma(Cronograma cronograma) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Cronograma (archivoCronograma)" + "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, cronograma.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(CronogramaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        cronogramas.add(cronograma);
    }

    @Override
    public void deleteCronograma(Cronograma cronograma) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Cronograma WERE idCronograma = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, cronograma.getIdCronograma());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(CronogramaDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        cronogramas.remove(cronograma);
    }
}
