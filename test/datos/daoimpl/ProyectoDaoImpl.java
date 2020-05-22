/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.daoimpl;

import datos.dao.ProyectoDao;
import datos.ConexionMySQL;
import entidades.Proyecto;
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
 * @author angel
 */
public class ProyectoDaoImpl implements ProyectoDao{
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public ProyectoDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Proyecto> getAllProyectos() {
        Proyecto proyecto;
        List<Proyecto> proyectos = new ArrayList<>();
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Proyecto";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                proyecto = new Proyecto();
                proyecto.setNombreProyecto(resultadoConsulta.getString("nombreProyecto"));
                proyecto.setDescripcionProyecto(resultadoConsulta.getString("descripcionProyecto"));
                proyecto.setRecursoProyecto(resultadoConsulta.getString("recursoProyecto"));
                proyecto.setDuracionProyecto(resultadoConsulta.getInt("duracionProyecto"));
                proyecto.setObjetivoProyecto(resultadoConsulta.getString("objetivoProyecto"));
                proyecto.setMetodologiaProyecto(resultadoConsulta.getString("metodologiaProyecto"));
                proyectos.add(proyecto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyectos;
    }

    @Override
    public Proyecto getProyectoByNombreProyecto(String nombreProyecto) {
        Proyecto proyecto = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Proyecto where nombreproyecto=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, nombreProyecto);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                proyecto = new Proyecto();
                proyecto.setNombreProyecto(resultadoConsulta.getString("nombreProyecto"));
                proyecto.setDescripcionProyecto(resultadoConsulta.getString("descripcionProyecto"));
                proyecto.setRecursoProyecto(resultadoConsulta.getString("recursoProyecto"));
                proyecto.setDuracionProyecto(resultadoConsulta.getInt("duracionProyecto"));
                proyecto.setObjetivoProyecto(resultadoConsulta.getString("objetivoProyecto"));
                proyecto.setMetodologiaProyecto(resultadoConsulta.getString("metodologiaProyecto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Proyecto (NombreProyecto, DescripcionProyecto,"
                + "RecursoProyecto, DuracionProyecto, ObjetivoProyecto, MetodologiaProyecto)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, proyecto.getNombreProyecto());
            sentencia.setString(2, proyecto.getDescripcionProyecto());
            sentencia.setString(3, proyecto.getRecursoProyecto());
            sentencia.setInt(4, proyecto.getDuracionProyecto());
            sentencia.setString(5, proyecto.getObjetivoProyecto());
            sentencia.setString(6, proyecto.getMetodologiaProyecto());

            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
    }

    @Override
    public void deleteProyecto(Proyecto proyecto) {
          try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM WHERE NombreProyecto = ?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, proyecto.getNombreProyecto());
            
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
    }
}