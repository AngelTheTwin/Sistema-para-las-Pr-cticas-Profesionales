/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.HorarioDao;
import datos.ConexionMySQL;
import entidades.Horario;
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
public class HorarioDaoImpl implements HorarioDao{
    private final ConexionMySQL conexion;
    private List<Horario> horarios;
    private ResultSet resultadoConsulta;

    public HorarioDaoImpl(){
        conexion = new ConexionMySQL();
    }
    @Override
    public List<Horario> getAllHorarios() {
        Horario horario;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Horario";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                horario = new Horario();
                horario.setIdHorario(resultadoConsulta.getString("idHorario"));
                horario.setArchivoHorario((File)resultadoConsulta.getObject("archivoHorario"));
                horarios.add(horario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horarios;

    }
    
    @Override
    public void saveHorario(Horario horario) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Horario (archivoHorario)" + "VALUES(?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setBytes(1, horario.getDocumento());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(HorarioDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        //horarios.add(horario);
    }
    
    @Override
    public void deleteHorario(Horario horario) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Horario WERE idHorario = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, horario.getIdHorario());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(HorarioDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        horarios.remove(horario);
    }

    @Override
    public Horario getHorarioByIdHorario(String idHorario) {
        Horario horario = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Horario where idHorario=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, idHorario);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                horario = new Horario();
                horario.setIdHorario(resultadoConsulta.getString("idHorario"));
                horario.setArchivoHorario((File)resultadoConsulta.getObject("archivoHorario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;
    }
}
