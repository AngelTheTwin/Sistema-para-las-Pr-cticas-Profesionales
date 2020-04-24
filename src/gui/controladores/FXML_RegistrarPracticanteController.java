/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.PracticanteDaoImpl;
import entidades.Practicante;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_RegistrarPracticanteController implements Initializable {

    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonCerrarSesion;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxTurnoPracticante.getItems().addAll("Matutino", "Vespertino", "Mixto");
        comboBoxGeneroPracticante.getItems().addAll("Masculino", "Femenino");
        comboBoxPeriodoPracticante.getItems().addAll("6", "7", "8", "9", "10", "11", "12");
    }    

    @FXML
    private void seleccionarRegistrarPracticante(ActionEvent event) {
        if(textAreaMatriculaPracticante.getText().isEmpty() || 
                textAreaNombrePracticante.getText().isEmpty() ||
                textAreaApellidoPaternoPracticante.getText().isEmpty() ||
                textAreaApellidoMaternoPracticante.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }else{
            Practicante practicante = new Practicante();
            PracticanteDaoImpl practicanteDao = new PracticanteDaoImpl();

            practicante.setMatricula(textAreaMatriculaPracticante.getText());
            practicante.setNombrePracticante(textAreaNombrePracticante.getText());
            practicante.setApellidoPaternoPracticante(textAreaApellidoPaternoPracticante.getText());
            practicante.setApellidoMaternoPracticante(textAreaApellidoMaternoPracticante.getText());
            practicante.setTurnoPracticante((String) comboBoxTurnoPracticante.getValue());
            practicante.setGeneroPracticante((String)comboBoxGeneroPracticante.getValue());
            practicante.setPeriodoPracticante(Integer.parseInt((String) comboBoxPeriodoPracticante.getValue()));
            practicante.setEstadoPracticante("Activo");
            
            this.textAreaMatriculaPracticante.setText("");
            this.textAreaNombrePracticante.setText("");
            this.textAreaApellidoPaternoPracticante.setText("");
            this.textAreaApellidoMaternoPracticante.setText("");

            practicanteDao.savePracticante(practicante);
        }
    }
    
}
