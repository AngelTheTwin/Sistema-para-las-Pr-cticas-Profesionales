/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ConexionMySQL {

    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "XNL5DVl073";
    private static final String contraseña = "hYycaSdWgk";
    private static final String url = "jdbc:mysql://remotemysql.com:3306/XNL5DVl073";
    
    public ConexionMySQL(){
        conexion = null;
        try{
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
