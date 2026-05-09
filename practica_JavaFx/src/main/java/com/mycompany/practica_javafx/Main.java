
package com.mycompany.practica_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;    
import javafx.stage.Stage;

public class Main extends Application {
    
    // 1. Declaramos el servicio aquí para que esté disponible en todo el método start
    private final ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        Button boton = new Button("Mostrar");
        Label label = new Label();

        boton.setOnAction(e -> {
            try {
                // Creamos el producto
                Producto p = new Producto(campo.getText());
                
                // 2. AGREGAR AL SERVICIO (Fuera del catch para que funcione cuando sea válido)
                servicio.agregar(p);
                
                // 3. ACTUALIZAR LA LISTA
                String texto = "Lista de productos:\n";
                for (Producto prod : servicio.listar()) {
                    texto += prod.getNombre() + "\n";
                }
                label.setText(texto);
                campo.clear(); // Limpia el cuadro de texto

            } catch (IllegalArgumentException ex) {
                // Si el nombre es inválido, mostramos el error
                label.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, campo, boton, label);
        Scene scene = new Scene(layout, 300, 400); // Aumenté el alto para ver la lista

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
