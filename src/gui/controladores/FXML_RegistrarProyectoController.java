/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.ProyectoDaoImpl;
import entidades.Proyecto;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_RegistrarProyectoController implements Initializable {

    @FXML
    private TextArea textAreaDescripcionProyecto;
    @FXML
    private TextArea textAreaRecursosProyecto;
    @FXML
    private TextArea textAreaObjetivoProyecto;
    @FXML
    private TextArea textAreaMetodologiaProyecto;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private TextArea textAreaNombreProyecto;
    @FXML
    private TextArea textAreaDuracionProyecto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonRegresar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 try{
                    Stage stagePrincipal = (Stage) buttonRegresar.getScene().getWindow();
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
    private void seleccionarRegistrarProyecto(ActionEvent event) {
                if(textAreaDescripcionProyecto.getText().isEmpty() || 
                textAreaRecursosProyecto.getText().isEmpty() ||
                textAreaObjetivoProyecto.getText().isEmpty() ||
                textAreaMetodologiaProyecto.getText().isEmpty() ||
                textAreaNombreProyecto.getText().isEmpty()||
                textAreaDuracionProyecto.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }else{
            Proyecto proyecto = new Proyecto();
            ProyectoDaoImpl proyectoDao = new ProyectoDaoImpl();

            proyecto.setDescripcionProyecto(textAreaDescripcionProyecto.getText());
            proyecto.setRecursoProyecto(textAreaRecursosProyecto.getText());
            proyecto.setObjetivoProyecto(textAreaObjetivoProyecto.getText());
            proyecto.setMetodologiaProyecto(textAreaMetodologiaProyecto.getText());
            proyecto.setNombreProyecto(textAreaNombreProyecto.getText());
            proyecto.setDuracionProyecto(Integer.parseInt(textAreaDuracionProyecto.getText()));
            
            this.textAreaDescripcionProyecto.setText("");
            this.textAreaRecursosProyecto.setText("");
            this.textAreaObjetivoProyecto.setText("");
            this.textAreaMetodologiaProyecto.setText("");
            this.textAreaNombreProyecto.setText("");
            this.textAreaDuracionProyecto.setText("");

            proyectoDao.saveProyecto(proyecto);
        }
    }
}
