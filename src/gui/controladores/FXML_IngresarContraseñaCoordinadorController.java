/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladores;

import datos.ConexionMySQL;
import datos.daoimpl.CoordinadorDaoImpl;
import entidades.Coordinador;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dagam
 */
public class FXML_IngresarContraseñaCoordinadorController implements Initializable {
    private final ConexionMySQL conexion;
    private ResultSet resultadoConsulta;
    @FXML
    private TextField textFieldNumeroPersonal;
    @FXML
    private PasswordField textFieldContraseña;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonRegresar;
    @FXML
    private PasswordField textFieldRepetirContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public FXML_IngresarContraseñaCoordinadorController(){
        conexion = new ConexionMySQL();
    }     

    @FXML
    private void registrarContraseña(ActionEvent event) throws SQLException {
        String usuario = textFieldNumeroPersonal.getText();
        String contraseña = String.valueOf(textFieldContraseña.getText());
        
        try(Connection conectar = conexion.obtenerConexion()){
            String consulta  = "Select * from Coordinador where NumeroPersonalCoordinador=?";
            PreparedStatement sentencia = conectar.prepareStatement(consulta);
            sentencia.setString(1, usuario);
            resultadoConsulta = sentencia.executeQuery();
            
            if(resultadoConsulta.next()){
                Coordinador coordinador = new Coordinador();
                CoordinadorDaoImpl coordinadorDao = new CoordinadorDaoImpl();

                coordinador.setContraseñaCoordinador(contraseña);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        }
    }   
}
