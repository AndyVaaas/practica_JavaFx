
package com.mycompany.practica_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;    
import javafx.stage.Stage;

public class Main extends Application {
   @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        Button boton = new Button("Mostrar");
        Label label = new Label();

        // Configuramos la acción del botón
        boton.setOnAction(e -> {
            try {
        Producto p = new Producto(campo.getText());
        label.setText(p.getNombre());
        } catch (Exception ex) {
        label.setText(ex.getMessage());
}
        });

        // Creamos el diseño y metemos los componentes
        VBox layout = new VBox(10, campo, boton, label);
        Scene scene = new Scene(layout, 300, 200);

        // Mostramos la ventana
        stage.setScene(scene);
        stage.show();
    }
    // No olvides agregar el main para que corra
    public static void main(String[] args) {
        launch(args);
    }
}
