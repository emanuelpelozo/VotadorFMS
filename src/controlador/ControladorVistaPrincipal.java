package controlador;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.FormatoFMS;
import vista.AlertaBatalla;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaPrincipal implements Initializable {

    private String pais;

    @FXML private BorderPane contenedorPrincipal;
    @FXML private VBox vistaSeleccion;
    private VBox vistaImagenCompetencia;
    @FXML private VBox vistaInicial;
    @FXML private Button btnNuevaBatalla;
    @FXML private Label labelSeleccionPais;
    @FXML private TextField txtFieldMC1;
    @FXML private TextField txtFieldMC2;
    @FXML private ImageView imgFMS;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String prompTextField = "Ingrese un nombre..";
//        this.vistaConfiguracion.setVisible(false);
        this.contenedorPrincipal.getChildren().remove(vistaSeleccion);
        this.txtFieldMC1.setPromptText(prompTextField);
        this.txtFieldMC2.setPromptText(prompTextField);

        this.vistaInicial.getStyleClass().add("vista-inicial");

    }

    @FXML
    public void nuevaBatallaButtonClicked(ActionEvent event){
        Stage window = (Stage) this.btnNuevaBatalla.getScene().getWindow();
        this.contenedorPrincipal.setBottom(vistaSeleccion);
//        this.vistaConfiguracion.setVisible(true);
//        this.imgFMS.setVisible(false);
        window.sizeToScene();
    }

    @FXML
    public void cargarBatallaButtonClicked(){

        this.vistaSeleccion.setVisible(false);
        this.imgFMS.setVisible(true);
    }

    @FXML
    public void comenzarBatallaButtonClicked(ActionEvent event) throws IOException {
        if(this.pais == null){

            AlertaBatalla alert = new AlertaBatalla(Alert.AlertType.ERROR);

            alert.setTitle("Información");
            alert.setHeaderText("No se puede comenzar la batalla.");
            alert.setContentText("Debe seleccionar un país para continuar.");
            alert.show();
            return;
        }

        this.verificarTxtFieldMC(this.txtFieldMC1,1);
        this.verificarTxtFieldMC(this.txtFieldMC2,2);

        FormatoFMS app = FormatoFMS.getInstance();
        app.iniciarBatallaNuevaEnPais(this.pais, this.txtFieldMC1.getText(), this.txtFieldMC2.getText());

        CambioDeEscena cambioDeEscena = new CambioDeEscena("../vista/vistaVotacion.fxml",
                (Node) event.getSource());

        cambioDeEscena.cambiarEscena();

        System.out.println("Pais: " + app.getPais());
        System.out.println("Competidor1: " + app.getCompetidorQueAtaca());
        System.out.println("Competidor2: "+  app.getCompetidorQueResponde());


    }

    private void verificarTxtFieldMC(TextField txtFieldMC, int nroCompetidor) {
        if(txtFieldMC.getText().isEmpty())
           txtFieldMC.setText("MC" + nroCompetidor);
    }

    @FXML
    public void iluminar(MouseEvent mouseEvent){
        vistaImagenCompetencia = (VBox) mouseEvent.getSource();
        vistaImagenCompetencia.setEffect(new Glow());

    }

    @FXML
    public void deshacerIluminacion(MouseEvent mouseEvent){
        vistaImagenCompetencia = (VBox) mouseEvent.getSource();
        vistaImagenCompetencia.setEffect(null);

    }


    @FXML
    private void imagenCompetenciaClicked(MouseEvent mouseEvent){
        vistaImagenCompetencia = (VBox) mouseEvent.getSource();
        ObservableList<Node> children = vistaImagenCompetencia.getChildren();
        children.forEach(node -> {
            if (node instanceof Label) {

                String paisSeleccionado =  ((Label) node).getText();
                this.pais = paisSeleccionado;
                this.labelSeleccionPais.setText("Pais seleccionado: "+ this.pais);

            }
        });


    }



}
