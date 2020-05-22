/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.UsuarioDaoImpl;
import entidades.Usuario;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.GenerardorDeContraseña;
import logica.Hash;
import logica.Validaciones;
import logica.enviarEmail;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_RegistrarProfesorController implements Initializable {

    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Label labelRegistrarProfesor;
    @FXML
    private Label labelNumeroPersonal;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelApellidoPaterno;
    @FXML
    private Label labelApellidoMaterno;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private TextField textFieldNumeroPersonal;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldApellidoPaterno;
    @FXML
    private TextField textFieldApellidoMaterno;
    @FXML
    private ComboBox comboBoxTurno;
    @FXML
    private TextField textFieldCorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxTurno.getItems().addAll("Matutino", "Vespertino", "Mixto");
        
        buttonCancelar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 try{
                    Stage stagePrincipal = (Stage) buttonCancelar.getScene().getWindow();
                    stagePrincipal.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_MenuAdministrador.fxml"));
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
    private void registrarDatosProfesor(ActionEvent event) {
        if(textFieldNumeroPersonal.getText().isEmpty() || 
                textFieldNombre.getText().isEmpty() ||
                textFieldApellidoPaterno.getText().isEmpty() ||
                textFieldApellidoMaterno.getText().isEmpty() ||
                textFieldCorreo.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }else{
            Validaciones email = new Validaciones();
            if(email.esEmail(textFieldCorreo.getText())){
                Usuario usuario = new Usuario();
                UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
                GenerardorDeContraseña contraseñaGenerada = new GenerardorDeContraseña();
                
                String contraseña= GenerardorDeContraseña.getPassword();
                
                String contraseñaHash = Hash.sha1(contraseña);
                
                enviarEmail.enviarEmail(contraseña, textFieldCorreo.getText());

                usuario.setMatricula(textFieldNumeroPersonal.getText());
                usuario.setNombre(textFieldNombre.getText());
                usuario.setApellidoPaterno(textFieldApellidoPaterno.getText());
                usuario.setApellidoMaterno(textFieldApellidoMaterno.getText());
                usuario.setEstado("Activo");
                usuario.setEmail(textFieldCorreo.getText());
                usuario.setTurno((String) comboBoxTurno.getValue());
                usuario.setContraseña(contraseñaHash);
                usuario.setTipoUsuario(3);

                this.textFieldNumeroPersonal.setText("");
                this.textFieldNombre.setText("");
                this.textFieldApellidoPaterno.setText("");
                this.textFieldApellidoMaterno.setText("");
                this.textFieldCorreo.setText("");

                usuarioDao.saveUsuario(usuario);
            }else{
                JOptionPane.showMessageDialog(null, "Correo electrónico no valido");
            }
        }
    }
}
