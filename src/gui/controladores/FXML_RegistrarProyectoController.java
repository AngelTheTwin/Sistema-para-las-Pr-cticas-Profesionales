/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package gui.controladores;

import datos.daoimpl.ProyectoDaoImpl;
import entidades.Proyecto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
        // TODO
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
