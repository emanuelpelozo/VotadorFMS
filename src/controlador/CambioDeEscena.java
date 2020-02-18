package controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CambioDeEscena {

    Parent vistaParent;
    Node nodoEscena;

    public CambioDeEscena(String nombreSource, Node nodoEnEscenaActual) throws IOException {

        vistaParent = FXMLLoader.load(getClass().getResource(nombreSource));
        this.nodoEscena = nodoEnEscenaActual;

    }

    public void cambiarEscena(){
        Scene vistaScene = new Scene(vistaParent);
        Stage window = (Stage)nodoEscena.getScene().getWindow();
        window.setScene(vistaScene);
    }

    public Parent getParent(){
        return this.vistaParent;
    }

//    vistaParent.setOnMousePressed(new EventHandler<MouseEvent>() {
//        @Override
//        public void handle(MouseEvent event) {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        }
//    });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//        @Override
//        public void handle(MouseEvent event) {
//            primaryStage.setX(event.getScreenX() - xOffset);
//            primaryStage.setY(event.getScreenY() - yOffset);
//        }
//    });

}
