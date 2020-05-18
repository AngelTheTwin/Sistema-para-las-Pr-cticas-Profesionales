/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladores;

import datos.ConexionMySQL;
import datos.dao.UsuarioDao;
import datos.daoimpl.UsuarioDaoImpl;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.IniciarMenu;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_LoginController implements Initializable {

    @FXML
    public TextField textFieldMatricula;
    @FXML
    private Button buttonAceptar;
    @FXML
    private PasswordField passwordFieldContraseña;
    
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    private ResultSet resultadoConsultaTipoUsuario;
    
    IniciarMenu iniciar = new IniciarMenu();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aceptar(ActionEvent event) throws SQLException, IOException {
        UsuarioDaoImpl usuario = new UsuarioDaoImpl();
        
        if(textFieldMatricula.getText().isEmpty() || passwordFieldContraseña.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los datos");
        }else{
            try(Connection conectar = conexion.obtenerConexion()){
                String matricula = textFieldMatricula.getText();
                String contraseña = String.valueOf(passwordFieldContraseña.getText());

                String consulta  = "Select * from Usuarios where Matricula=? and Contraseña=?";
                PreparedStatement sentencia = conectar.prepareStatement(consulta);
                sentencia.setString(1, matricula);
                sentencia.setString(2, contraseña);
                resultadoConsulta = sentencia.executeQuery();

                if(resultadoConsulta.next()){
                int tipoUsuario; 
                
                    if(resultadoConsulta.first()){
                        tipoUsuario = resultadoConsulta.getInt("Tipo_Usuario");
                        
                        System.out.println(tipoUsuario);
                        
                        if(tipoUsuario == 1)
                        iniciar.iniciarMenuAdministrador();
                        
                        if(tipoUsuario == 2)
                        iniciar.iniciarMenuCoordinador();
                        
                        if(tipoUsuario == 3)
                        iniciar.iniciarMenuProfesor();
                        
                        if(tipoUsuario == 4)
                        iniciar.iniciarMenuPracticante();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Matrícula o contraseña incorrectos");
                    this.textFieldMatricula.setText("");
                    this.passwordFieldContraseña.setText("");
                }
            }
        }
    }
    
    public FXML_LoginController(){
        conexion = new ConexionMySQL();
    }     
}
