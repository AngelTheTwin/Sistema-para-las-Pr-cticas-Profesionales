/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.ProfesorDaoImpl;
import entidades.Profesor;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        
       buttonEliminar.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event){
            
        if(textFieldNumeroPersonal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
        }else{
            Profesor profesor = new Profesor();
            ProfesorDaoImpl profesorDao = new ProfesorDaoImpl();
            
            profesor.setNumeroPersonalProfesor(textFieldNumeroPersonal.getText());
            
            profesorDao.deleteProfesor(profesor);
        } 
        }
    }); 
       
       buttonRegresar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                    Stage stagePrincipal = (Stage) buttonRegresar.getScene().getWindow();
                    stagePrincipal.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_AdministrarProfesor.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    stage.show();
               } catch(IOException ex) {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Error al crear ventana.", ex);
                }
           }
       });
    }    

     
}
