package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Batalla.FabricaRounds;
import modelo.FormatoFMS;
import vista.VistaTabPaneRounds;
import vista.tableroVotacion.VistaRoundParaPuntuacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaVotacion implements Initializable {

    private FormatoFMS app;
    @FXML private VBox vistaOpciones;
    @FXML private JFXToggleButton toggleOpciones;
    @FXML private BorderPane contenedorPrincipal;
    @FXML private JFXButton btnSalir;
    private VistaTabPaneRounds vistaTabPane;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.app = FormatoFMS.getInstance();
        this.vistaTabPane = new VistaTabPaneRounds(app);

        this.contenedorPrincipal.setTop(vistaTabPane);

        this.app.setEasyMode();

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


