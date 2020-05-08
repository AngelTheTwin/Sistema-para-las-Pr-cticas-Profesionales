/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladores;

import datos.ConexionMySQL;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_InicioDeSesionPracticanteController implements Initializable {
    
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;

    @FXML
    private Label labelInicioDeSesion;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private Button buttonIniciarSesion;
    @FXML
    private Button buttonSalir;
    @FXML
    private Label labelUsuario;
    @FXML
    private Label labelContraseña;
    @FXML
    private PasswordField passwordFieldContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            buttonIniciarSesion.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent event) {
                    try {
                        validarAccesoPracticante();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXML_InicioDeSesionPracticanteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            buttonSalir.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 try{
                    Stage stagePrincipal = (Stage) buttonSalir.getScene().getWindow();
                    stagePrincipal.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuUsuario.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch(IOException ex) {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Error al crear ventana.", ex);
                }
            }  
        });
    }
    
    @FXML
    public void validarAccesoPracticante() throws SQLException{
        
        try(Connection conectar = conexion.obtenerConexion()){
            String usuario = textFieldUsuario.getText();
            String contraseña = String.valueOf(passwordFieldContraseña.getText());
             
            String consulta  = "Select * from Practicante where MatriculaPracticante=? and ContraseñaPracticante=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, usuario);
            sentencia.setString(2, contraseña);
            resultadoConsulta = sentencia.executeQuery();
            
            if(resultadoConsulta.next()){
            try{
                Stage ventanaPrincipal = (Stage) buttonIniciarSesion.getScene().getWindow();
                ventanaPrincipal.close();
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
            }else{
                JOptionPane.showMessageDialog(null, "Número de personal o contraseña incorrectos");
                this.textFieldUsuario.setText("");
                this.passwordFieldContraseña.setText("");
            }
        }
    }
    
    public FXML_InicioDeSesionPracticanteController(){
        conexion = new ConexionMySQL();
    }
}
