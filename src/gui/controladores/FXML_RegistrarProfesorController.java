/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.ProfesorDaoImpl;
import entidades.Profesor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxTurno.getItems().addAll("Matutino", "Vespertino");
    }
            
    @FXML
    private void registrarDatosProfesor(ActionEvent event) {
        if(textFieldNumeroPersonal.getText().isEmpty() || 
                textFieldNombre.getText().isEmpty() ||
                textFieldApellidoPaterno.getText().isEmpty() ||
                textFieldApellidoMaterno.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }else{
            Profesor profesor = new Profesor();
            ProfesorDaoImpl profesorDao = new ProfesorDaoImpl();

            profesor.setNumeroPersonalProfesor(textFieldNumeroPersonal.getText());
            profesor.setNombreProfesor(textFieldNombre.getText());
            profesor.setApellidoPaternoProfesor(textFieldApellidoPaterno.getText());
            profesor.setApellidoMaternoProfesor(textFieldApellidoMaterno.getText());
            profesor.setTurnoProfesor((String) comboBoxTurno.getValue());
            profesor.setEstadoProfesor("Activo");
            
            this.textFieldNumeroPersonal.setText("");
            this.textFieldNombre.setText("");
            this.textFieldApellidoPaterno.setText("");
            this.textFieldApellidoMaterno.setText("");

            profesorDao.saveProfesor(profesor);
        }
    }
}
