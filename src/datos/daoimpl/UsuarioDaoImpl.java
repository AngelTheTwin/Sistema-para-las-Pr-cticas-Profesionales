/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import datos.dao.UsuarioDao;
import datos.ConexionMySQL;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dagam
 */
public class UsuarioDaoImpl implements UsuarioDao{
        List<Usuario> usuarios;
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    
    public UsuarioDaoImpl(){
        conexion = new ConexionMySQL();
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        Usuario usuario;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Usuarios";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                usuario = new Usuario();
                usuario.setMatricula(resultadoConsulta.getString("matricula"));
                usuario.setNombre(resultadoConsulta.getString("nombre"));
                usuario.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                usuario.setContraseña(resultadoConsulta.getString("contraseña"));
                usuario.setEstado(resultadoConsulta.getString("estado"));
                usuario.setTurno(resultadoConsulta.getString("turno"));
                usuario.setTipoUsuario(resultadoConsulta.getInt("tipoUsuario"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuarioByMatricula(String matricula) {
        Usuario usuario = null;
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Usuarios where matricula=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, matricula);
            resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                usuario = new Usuario();
                usuario.setMatricula(resultadoConsulta.getString("matricula"));
                usuario.setNombre(resultadoConsulta.getString("nombre"));
                usuario.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                usuario.setContraseña(resultadoConsulta.getString("contraseña"));
                usuario.setEstado(resultadoConsulta.getString("estado"));
                usuario.setTurno(resultadoConsulta.getString("turno"));
                usuario.setTipoUsuario(resultadoConsulta.getInt("tipoUsuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "INSERT INTO Usuarios (Matricula, Nombre,"
                + "ApellidoPaterno, ApellidoMaterno, Contraseña, Estado, Turno, Tipo_Usuario)" + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, usuario.getMatricula());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellidoPaterno());
            sentencia.setString(4, usuario.getApellidoMaterno());
            sentencia.setString(5, usuario.getContraseña());
            sentencia.setString(6, usuario.getEstado());
            sentencia.setString(7, usuario.getTurno());
            sentencia.setInt(8, usuario.getTipoUsuario());

            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            System.out.println("ERROR: No se han podido guardar los datos." + excepcion.getMessage());
        }finally{
            conexion.desconectar();
        }
        usuarios.add(usuario);
    }
    @Override    
    public void deleteUsuario(Usuario usuario) {
        try(Connection conectar = conexion.obtenerConexion()){
            String consultaSQL = "DELETE FROM Usuarios WHERE Matricula=?";
            PreparedStatement sentencia = conectar.prepareStatement(consultaSQL);
            sentencia.setString(1, usuario.getMatricula());
            sentencia.execute();
            sentencia.close();
        }catch(SQLException excepcion){
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            conexion.desconectar();
        }
        usuarios.remove(usuario);
    }
}
