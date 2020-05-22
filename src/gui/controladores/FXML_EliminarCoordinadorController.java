/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladores;


import datos.daoimpl.CoordinadorDaoImpl;
import entidades.Coordinador;
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
 * @author PCF JOSE
 */
public class FXML_EliminarCoordinadorController implements Initializable {
    
    private Button buttonEliminar; 
    
    private Button buttonRegresar;
    
    private TextField textFieldNumeroPersonal;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        buttonEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(textFieldNumeroPersonal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
        }else{
            Coordinador coordinador = new Coordinador();
            CoordinadorDaoImpl coordinadorDao = new CoordinadorDaoImpl();
            
            coordinador.setNumeroPersonalCoordinador(textFieldNumeroPersonal.getText());
            
            coordinadorDao.deleteCoordinador(coordinador);
        }
            }
        });
        
        buttonRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               try {
                    Stage stagePrincipal = (Stage) buttonRegresar.getScene().getWindow();
                    stagePrincipal.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/vistas/FXML_AdministrarCoordinador.fxml"));
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
