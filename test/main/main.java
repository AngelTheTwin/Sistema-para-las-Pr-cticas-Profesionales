/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.class.getResource("/gui/vistas/FXML_RegistrarCoordinador.fxml"));
        Pane ventana = (Pane) loader.load();

        Scene escena = new Scene(ventana);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
