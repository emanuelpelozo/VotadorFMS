package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaVotacion implements Initializable {
    @FXML private VBox vistaOpciones;
    @FXML private JFXToggleButton toggleOpciones;
    @FXML private BorderPane contenedorPrincipal;
    @FXML private JFXButton btnSalir;


    public void initialize(URL url, ResourceBundle resourceBundle) {


//        Parent root = this.vistaOpciones.getParent();
//        root.setOnMousePressed(event -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//        root.setOnMouseDragged(event -> {
//            primaryStage.setX(event.getScreenX() - xOffset);
//            primaryStage.setY(event.getScreenY() - yOffset);
//        });


    }

    @FXML
    private void ocultarOpcionesClicked(ActionEvent event){

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        if (this.toggleOpciones.isSelected()){
            this.contenedorPrincipal.setBottom(null);
            window.sizeToScene();
            return;
        }
        this.contenedorPrincipal.setBottom(vistaOpciones);
        window.sizeToScene();

    }


    @FXML
    private void botonSalirClicked(ActionEvent event){

        Stage window = (Stage) this.btnSalir.getScene().getWindow();
        window.close();
    }


    @FXML
    private void botonNuevaBatallaClicked(ActionEvent event) throws IOException {
       CambioDeEscena cambioDeEscena = new CambioDeEscena("../vista/vistaPrincipal.fxml",
                (Node) event.getSource());

        cambioDeEscena.cambiarEscena();

    }
}


