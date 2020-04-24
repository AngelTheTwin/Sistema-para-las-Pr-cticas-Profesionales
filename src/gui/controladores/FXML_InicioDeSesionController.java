/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class FXML_InicioDeSesionController implements Initializable {

    @FXML
    private Label labelInicioDeSesion;
    @FXML
    private Button buttonIniciarSesion;
    @FXML
    private Button buttonSalir;
    @FXML
    private Label labelUsuario;
    @FXML
    private Label labelContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
