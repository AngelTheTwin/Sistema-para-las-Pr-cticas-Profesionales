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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_EliminarProfesorController implements Initializable {

    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonEliminar;
    @FXML
    private Label labelDescripcion;
    @FXML
    private Button buttonRegresar;
    @FXML
    private TextField textFieldNumeroPersonal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seleccionarBotonEliminar(ActionEvent event) {
        if(textFieldNumeroPersonal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
        }else{
            Profesor profesor = new Profesor();
            ProfesorDaoImpl profesorDao = new ProfesorDaoImpl();
            
            profesor.setNumeroPersonalProfesor(textFieldNumeroPersonal.getText());
            
            profesorDao.deleteProfesor(profesor);
        } 
    }  
}
