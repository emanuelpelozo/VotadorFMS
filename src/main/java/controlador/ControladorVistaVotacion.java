package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Batalla.Batalla;
import modelo.Batalla.FabricaRounds;
import modelo.FormatoFMS;
import vista.IntField;
import vista.resultados.VistaResumenRound;
import vista.tableroVotacion.VistaPuntajeTotal;
import vista.tableroVotacion.VistaTabPaneRounds;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaVotacion implements Initializable {

    private FormatoFMS app;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private VBox vistaOpcionesSecundarias;
    @FXML private VBox vistaOpcionesPrincipales;
    @FXML private JFXToggleButton toggleOpciones;
    @FXML private BorderPane contenedorPrincipal;
    @FXML private JFXButton btnSalir;
    @FXML private StackPane stackVotacion;
    private VistaTabPaneRounds vistaTabPane;
    @FXML private Label labelGanador;
    @FXML private VBox vistaResultados;
    @FXML private JFXRadioButton radioButtonSumRound;
    @FXML private JFXRadioButton radioButtonSumTotal;
    @FXML private HBox botoneraResultados;
    @FXML private HBox contenedorDistMinima;
    private IntField casillaDistMinima;
    private VistaPuntajeTotal vistaPuntajeTotal;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.app = FormatoFMS.getInstance();

        this.stackVotacion.setPrefSize(750,160);
        this.stackVotacion.getStyleClass().add("vista-puntaje");

        this.vistaResultados.getChildren().add(1, new HBox());
        this.vistaResultados.setVisible(false);

        this.vistaTabPane = new VistaTabPaneRounds(app);
        this.stackVotacion.getChildren().add(vistaTabPane);

        this.app.setEasyMode();

        this.vistaPuntajeTotal = new VistaPuntajeTotal(app.getCompetidor1(), app.getCompetidor2());
        this.vistaOpcionesPrincipales.getChildren().add(0, vistaPuntajeTotal);

        contenedorPrincipal.setOnKeyReleased( e->{
            int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor1());
            int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor2());
            vistaPuntajeTotal.actualizarPuntajes(pje1,pje2);
        });

        this.inicializarCasillaDistMinima();




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



    }

    private void inicializarCasillaDistMinima() {
        this.casillaDistMinima = new IntField(0,9,5);
        this.casillaDistMinima.setMaxSize(15,15);
        this.casillaDistMinima.getStyleClass().add("casilla-puntaje");
        this.casillaDistMinima.setAlignment(Pos.CENTER);
        this.contenedorDistMinima.getChildren().add(casillaDistMinima);
        this.casillaDistMinima.setOnKeyTyped(e->{
            app.setDistanciaMinimaParaReplica(casillaDistMinima.getValue());
        });
    }


    @FXML
    private void ocultarOpcionesClicked(ActionEvent event) {

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (this.toggleOpciones.isSelected()) {
            this.contenedorPrincipal.setBottom(null);
            window.sizeToScene();
            return;
        }
        this.contenedorPrincipal.setBottom(vistaOpcionesSecundarias);
        window.sizeToScene();

    }


    @FXML
    private void botonSalirClicked(ActionEvent event) {

        Stage window = (Stage) this.btnSalir.getScene().getWindow();
        window.close();
    }


    @FXML
    private void botonNuevaBatallaClicked(ActionEvent event) throws IOException {
        CambioDeEscena cambioDeEscena = new CambioDeEscena("/vistaPrincipal.fxml",
                (Node) event.getSource());

        cambioDeEscena.cambiarEscena();

    }

    @FXML
    private void botonObtenerResultadosClicked() {

        HBox resumenBatalla = this.crearResumenBatalla();
        resumenBatalla.setAlignment(Pos.CENTER);
        this.stackVotacion.getChildren().remove(vistaTabPane);
        this.vistaResultados.getChildren().set(1, resumenBatalla);
        this.vistaResultados.setVisible(true);
        this.establecerVistaGanador();
    }

    private void establecerVistaGanador() {
        String ganador = app.getGanador();
        this.labelGanador.setText("El ganador es: " + app.getGanador());
        if(ganador == Batalla.REPLICA){
            this.agregarBotonReplica();
        }
    }

    private void agregarBotonReplica() {
        Button btnReplica = new Button("Ir a replica");
        this.botoneraResultados.getChildren().add(btnReplica);
        btnReplica.setOnAction(e->{
            this.botoneraResultados.getChildren().remove(btnReplica);
            this.vistaTabPane.agregarTabReplica();
        });
        
    }

    private HBox crearResumenBatalla() {
        HBox resumenBatalla = new HBox();
        resumenBatalla.setSpacing(10);

        VBox etiquetas = new VBox(new Label("Round: "),
                new Label(app.getCompetidor1()), new Label(app.getCompetidor2()));

        resumenBatalla.getChildren().add(etiquetas);
        this.crearVistaResumenRound(
                FabricaRounds.EASY_MODE, resumenBatalla);

        this.crearVistaResumenRound(
                FabricaRounds.HARD_MODE, resumenBatalla);

        this.crearVistaResumenRound(
                FabricaRounds.TEMATICA_IDA, resumenBatalla);
        this.crearVistaResumenRound(
                FabricaRounds.TEMATICA_VTA, resumenBatalla);
        this.crearVistaResumenRound(
                FabricaRounds.PERSONAJES, resumenBatalla);
        this.crearVistaResumenRound(
                FabricaRounds.LIBRE_IDA, resumenBatalla);
        this.crearVistaResumenRound(
                FabricaRounds.LIBRE_VTA, resumenBatalla);
        this.crearVistaResumenRound(
                FabricaRounds.DELUXE, resumenBatalla);

        return resumenBatalla;
    }

    private void crearVistaResumenRound(String nombreRound, HBox contenedorResumen) {
        VistaResumenRound resumen = new VistaResumenRound(nombreRound);
        app.setRound(nombreRound);
        int pje1 = app.getPuntajeRoundActualParaCompetidor(app.getCompetidor1());
        int pje2 = app.getPuntajeRoundActualParaCompetidor(app.getCompetidor2());
        String ganador = app.getGanadorRoundActual();
//        resumen.setGanador(ganador);
        resumen.setPuntaje1(pje1);
        resumen.setPuntaje2(pje2);

        contenedorResumen.getChildren().add(resumen);

    }

    @FXML
    private void botonVolverAPlanillaClicked() {
        this.stackVotacion.getChildren().add(vistaTabPane);
        this.vistaResultados.setVisible(false);
        this.actualizarStage();
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
            this.vistaOpcionesPrincipales.getChildren().remove(vistaPuntajeTotal);

        } else
            this.vistaOpcionesPrincipales.getChildren().add(0, vistaPuntajeTotal);
        this.actualizarStage();
    }

    private void actualizarStage() {
        Stage window = (Stage) this.contenedorPrincipal.getScene().getWindow();
        window.sizeToScene();
    }
}


