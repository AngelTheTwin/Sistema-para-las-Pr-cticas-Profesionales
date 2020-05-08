/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ConexionMySQL {
    
   public static Properties configuracion = new Properties();
   public static InputStream configInput = null;
   
    private static Connection conexion;
    private static  String driver = null;
    private static  String usuario = null;
    private static  String contraseña = null;
    private static  String url = null;
    
     
    
    public ConexionMySQL(){
        conexion = null;
        try{
            configInput = new FileInputStream("Conexion");
            configuracion.load(configInput);
            driver = configuracion.getProperty("driver");
            usuario = configuracion.getProperty("usuario");
            contraseña = configuracion.getProperty("contraseña");
            url = configuracion.getProperty("url");
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            if(conexion != null){
                System.out.println("Conexión establecida");
            }
        }catch(SQLException excepcion){
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, excepcion);
            System.out.println(excepcion);
        } catch (ClassNotFoundException excepcion) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, excepcion);
        } catch (FileNotFoundException ex) {
           Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
}
