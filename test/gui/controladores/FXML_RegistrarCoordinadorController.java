/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.CoordinadorDaoImpl;
import entidades.Coordinador;
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
public class FXML_RegistrarCoordinadorController implements Initializable {

    @FXML
    private Label labelRegistrarCoordinador;
    @FXML
    private Label labelNumeroPersonal;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelApellidoPaterno;
    @FXML
    private Label labelApellidoMaterno;
    @FXML
    private TextField textFieldNumeroPersonal;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldApellidoPaterno;
    @FXML
    private TextField textFieldApellidoMaterno;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonRegistrar;
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
    private void click(ActionEvent event) {
    }

    @FXML
    private void registrarDatosCoordinador(ActionEvent event) {
        if(textFieldNumeroPersonal.getText().isEmpty() || 
                textFieldNombre.getText().isEmpty() ||
                textFieldApellidoPaterno.getText().isEmpty() ||
                textFieldApellidoMaterno.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
        }else{
            Coordinador coordinador = new Coordinador();
            CoordinadorDaoImpl coordinadorDao = new CoordinadorDaoImpl();

            coordinador.setNumeroPersonalCoordinador(textFieldNumeroPersonal.getText());
            coordinador.setNombreCoordinador(textFieldNombre.getText());
            coordinador.setApellidoPaternoCoordinador(textFieldApellidoPaterno.getText());
            coordinador.setApellidoMaternoCoordinador(textFieldApellidoMaterno.getText());
            coordinador.setTurnoCoordinador((String) comboBoxTurno.getValue());
            coordinador.setEstadoCoordinador("Activo");
            
            this.textFieldNumeroPersonal.setText("");
            this.textFieldNombre.setText("");
            this.textFieldApellidoPaterno.setText("");
            this.textFieldApellidoMaterno.setText("");

            coordinadorDao.saveCoordinador(coordinador);
        }    
    }    
}
