/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_RegistroContraseñaController implements Initializable {

    @FXML
    private PasswordField passwordFieldContraseña;
    @FXML
    private PasswordField passwordFieldRepetirContraseña;
    @FXML
    private Button buttonAceptar;
    @FXML
    private Button buttonRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void aceptar(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
