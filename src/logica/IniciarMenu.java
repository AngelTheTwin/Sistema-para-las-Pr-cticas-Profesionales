/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.ConexionMySQL;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author dagam
 */
public class IniciarMenu {
    
    public void iniciarMenuAdministrador(Button buttonAceptar){
        try{
            Stage stagePrincipal = (Stage) buttonAceptar.getScene().getWindow();
            stagePrincipal.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuAdministrador.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage escenario = new Stage();
            escenario.setResizable(false);
            escenario.setScene(new Scene(root));
            escenario.show();
        }catch(IOException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Error al crear ventana.", ex);
        }
    }
    
    public void iniciarMenuCoordinador(Button buttonAceptar){
        try{
            Stage stagePrincipal = (Stage) buttonAceptar.getScene().getWindow();
            stagePrincipal.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuCoordinador.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage escenario = new Stage();
            escenario.setResizable(false);
            escenario.setScene(new Scene(root));
            escenario.show();
        }catch(IOException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Error al crear ventana.", ex);
        }
    }
        
    public void iniciarMenuProfesor(Button buttonAceptar){
        try{
            Stage stagePrincipal = (Stage) buttonAceptar.getScene().getWindow();
            stagePrincipal.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuProfesor.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage escenario = new Stage();
            escenario.setResizable(false);
            escenario.setScene(new Scene(root));
            escenario.show();
        }catch(IOException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Error al crear ventana.", ex);
        }
    }
            
    public void iniciarMenuPracticante(Button buttonAceptar){
        try{
            Stage stagePrincipal = (Stage) buttonAceptar.getScene().getWindow();
            stagePrincipal.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuPracticante.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage escenario = new Stage();
            escenario.setResizable(false);
            escenario.setScene(new Scene(root));
            escenario.show();
        }catch(IOException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Error al crear ventana.", ex);
        }
    }
}
