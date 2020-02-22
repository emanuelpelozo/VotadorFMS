package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntajeTotal;
import vista.tableroVotacion.VistaTabPaneRounds;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaVotacion implements Initializable {

    private FormatoFMS app;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private VBox vistaOpciones;
    @FXML
    private JFXToggleButton toggleOpciones;
    @FXML
    private BorderPane contenedorPrincipal;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnObtenerResultados;
    @FXML private StackPane stackVotacion;
    private VistaTabPaneRounds vistaTabPane;
    @FXML
    private Label labelGanador;
    @FXML
    private VBox vistaResultados;
    @FXML
    private JFXRadioButton radioButtonSumRound;
    @FXML
    private JFXRadioButton radioButtonSumTotal;
    private VistaPuntajeTotal puntajeTotal1;
    private VistaPuntajeTotal puntajeTotal2;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.app = FormatoFMS.getInstance();
        this.vistaTabPane = new VistaTabPaneRounds(app);

        this.vistaResultados.setVisible(false);
        this.stackVotacion.getChildren().add(vistaTabPane);

        this.app.setEasyMode();

        contenedorPrincipal.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        contenedorPrincipal.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage window = (Stage) contenedorPrincipal.getScene().getWindow();
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });

        this.vistaTabPane.setOnKeyReleased(new TabPaneEventHandler());

//        this.puntajeTotal1 = new VistaPuntajeTotal(app.getCompetidorQueAtaca(), app.getCompetidorQueResponde());
//        this.contenedorPrincipal.setLeft(puntajeTotal1);
//        this.contenedorPrincipal.setRight(puntajeTotal1);

//        this.contenedorPrincipal.setOnKeyReleased(e->{
//            BorderPane border = (BorderPane) e.getSource();
//            VistaPuntajeTotal vistaTotal = (VistaPuntajeTotal) border.getLeft();
//            int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueAtaca());
//            int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueResponde());
//            vistaTotal.actualizarPuntajes(pje1,pje2);
//        });


    }


    @FXML
    private void ocultarOpcionesClicked(ActionEvent event) {

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (this.toggleOpciones.isSelected()) {
            this.contenedorPrincipal.setBottom(null);
            window.sizeToScene();
            return;
        }
        this.contenedorPrincipal.setBottom(vistaOpciones);
        window.sizeToScene();

    }


    @FXML
    private void botonSalirClicked(ActionEvent event) {

        Stage window = (Stage) this.btnSalir.getScene().getWindow();
        window.close();
    }


    @FXML
    private void botonNuevaBatallaClicked(ActionEvent event) throws IOException {
        CambioDeEscena cambioDeEscena = new CambioDeEscena("../vista/vistaPrincipal.fxml",
                (Node) event.getSource());

        cambioDeEscena.cambiarEscena();

    }

    @FXML
    private void botonObtenerResultadosClicked() {

        String ganador = app.getGanador();
        this.labelGanador.setText(ganador);
        this.stackVotacion.getChildren().remove(vistaTabPane);
        this.vistaResultados.setVisible(true);
    }

    @FXML
    private void botonVolverAPlanillaClicked() {
        this.stackVotacion.getChildren().add(vistaTabPane);
        this.vistaResultados.setVisible(false);
    }

    @FXML
    private void ocultarSumatoriaRoundClicked() {
        if (this.radioButtonSumRound.isSelected()) {
            this.vistaTabPane.ocultarSumatoriaRound();
            return;
        }
        this.vistaTabPane.mostrarSumatoriaRound();
    }

    @FXML
    private void ocultarSumatoriaTotalClicked() {
        if (radioButtonSumTotal.isSelected()) {
            this.vistaTabPane.ocultarSumatoriaTotal();
        } else {
            this.vistaTabPane.mostrarSumatoriaTotal();
        }
    }
}


