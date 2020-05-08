/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.main;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_AdministrarProfesorController implements Initializable {

    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonRegistrarProfesor;
    @FXML
    private Button buttonEliminarProfesor;
    @FXML
    private Button buttonEditarProfesor;
    @FXML
    private Button buttonBuscarProfesor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seleccionarRegistrarProfesor(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void seleccionarEliminarProfesor(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void seleccionarEditarProfesor(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void seleccionarBuscarProfesor(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
