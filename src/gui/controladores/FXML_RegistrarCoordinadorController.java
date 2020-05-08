/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        
        buttonCancelar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 try{
                    Stage stagePrincipal = (Stage) buttonCancelar.getScene().getWindow();
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
