/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.PracticanteDaoImpl;
import datos.daoimpl.UsuarioDaoImpl;
import entidades.Practicante;
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
import javafx.scene.control.TextArea;
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
public class FXML_RegistrarPracticanteController implements Initializable {

    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private TextArea textAreaMatriculaPracticante;
    @FXML
    private TextArea textAreaNombrePracticante;
    @FXML
    private TextArea textAreaApellidoPaternoPracticante;
    @FXML
    private TextArea textAreaApellidoMaternoPracticante;
    @FXML
    private ComboBox comboBoxTurnoPracticante;
    @FXML
    private ComboBox comboBoxGeneroPracticante;
    @FXML
    private ComboBox comboBoxPeriodoPracticante;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonCancelar;
    @FXML
    private TextArea textAreaCorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxTurnoPracticante.getItems().addAll("Matutino", "Vespertino", "Mixto");
        comboBoxGeneroPracticante.getItems().addAll("Masculino", "Femenino");
        comboBoxPeriodoPracticante.getItems().addAll("6", "7", "8", "9", "10", "11", "12");
        
        buttonRegresar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 try{
                    Stage stagePrincipal = (Stage) buttonRegresar.getScene().getWindow();
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
    private void regresar(ActionEvent event) {
    }

    @FXML
    private void registrar(ActionEvent event) {
                if(textAreaMatriculaPracticante.getText().isEmpty() || 
                textAreaNombrePracticante.getText().isEmpty() ||
                textAreaApellidoPaternoPracticante.getText().isEmpty() ||
                textAreaApellidoMaternoPracticante.getText().isEmpty() ||
                textAreaCorreo.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }else{
            Validaciones email = new Validaciones();
            if(email.esEmail(textAreaCorreo.getText())){
                Usuario usuario = new Usuario();
                UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
                Practicante practicante = new Practicante();
                PracticanteDaoImpl practicanteDao = new PracticanteDaoImpl();
                GenerardorDeContraseña contraseñaGenerada = new GenerardorDeContraseña();
                
                String contraseña= GenerardorDeContraseña.getPassword();
                
                String contraseñaHash = Hash.sha1(contraseña);
                
                enviarEmail.enviarEmail(contraseña, textAreaCorreo.getText());
                
                usuario.setMatricula(textAreaMatriculaPracticante.getText());
                usuario.setNombre(textAreaNombrePracticante.getText());
                usuario.setApellidoPaterno(textAreaApellidoPaternoPracticante.getText());
                usuario.setApellidoMaterno(textAreaApellidoMaternoPracticante.getText());
                usuario.setEstado("Activo");
                usuario.setContraseña(contraseñaHash);
                usuario.setEmail(textAreaCorreo.getText());
                usuario.setTurno((String) comboBoxTurnoPracticante.getValue());
                usuario.setTipoUsuario(4);
                 
                this.textAreaMatriculaPracticante.setText("");
                this.textAreaNombrePracticante.setText("");
                this.textAreaApellidoPaternoPracticante.setText("");
                this.textAreaApellidoMaternoPracticante.setText("");
                this.textAreaCorreo.setText("");
                
                usuarioDao.saveUsuario(usuario);
            }else{
                JOptionPane.showMessageDialog(null, "Correo electrónico no valido");
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}
