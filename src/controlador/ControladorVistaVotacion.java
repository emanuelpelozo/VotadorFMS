package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Batalla.FabricaRounds;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaRoundParaPuntuacion;

import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;

public class ControladorVistaVotacion implements Initializable {
    @FXML private VBox vistaOpciones;
    @FXML private JFXToggleButton toggleOpciones;
    @FXML private BorderPane contenedorPrincipal;
    @FXML private JFXButton btnSalir;
    @FXML private JFXTabPane tabPane;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.cargarVistaRounds();

//        FormatoFMS app = FormatoFMS.getInstance();
//        String competidor1 = app.getCompetidorQueAtaca();
//        String competidor2 = app.getCompetidorQueResponde();
//        VistaRoundParaPuntuacion vistaRound = new VistaRoundParaPuntuacion("Easy Mode", competidor1,competidor2);
//        vistaRound.inciarParaCantidadDeRounds(5);
//        this.tabPane.getTabs().get(0).setContent(vistaRound);


        this.contenedorPrincipal.setOnKeyReleased(e-> {
            VistaRoundParaPuntuacion vista = (VistaRoundParaPuntuacion) this.tabPane.getSelectionModel().getSelectedItem().getContent();
            vista.actualizarAcumulado();
        });

    }

    private void cargarVistaRounds() {
        FormatoFMS app = FormatoFMS.getInstance();
        HBox round = new HBox();
        round.setSpacing(20);

        VistaRoundParaPuntuacion vista = new
                VistaRoundParaPuntuacion(FabricaRounds.EASY_MODE,
                app.getCompetidorQueAtaca(), app.getCompetidorQueResponde());
        vista.inciarParaCantidadDeRounds(FabricaRounds.ENTRADAS_EMODE);

        round.getChildren().add(vista);

        app.setHardMode();
        vista = new VistaRoundParaPuntuacion(FabricaRounds.HARD_MODE,
                app.getCompetidorQueAtaca(), app.getCompetidorQueResponde());
        vista.inciarParaCantidadDeRounds(FabricaRounds.ENTRADAS_HMODE);
        round.getChildren().add(vista);

        this.tabPane.getTabs().get(0).setContent(round);
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


