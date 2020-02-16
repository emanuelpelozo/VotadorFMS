package controlador;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modelo.FormatoFMS;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVistaPrincipal implements Initializable {

    private String pais;


    @FXML private VBox vistaConfiguracion;
    private VBox vistaImagenCompetencia;
    @FXML private JFXTextField txtFieldMC1;
    @FXML private JFXTextField txtFieldMC2;
    @FXML private ImageView imgFMS;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String prompTextField = "Ingrese un nombre..";
        this.vistaConfiguracion.setVisible(false);
        this.txtFieldMC1.setPromptText(prompTextField);
        this.txtFieldMC2.setPromptText(prompTextField);

    }

    public void nuevaBatallaButtonClicked(){

        this.vistaConfiguracion.setVisible(true);
        this.imgFMS.setVisible(false);
    }

    public void cargarBatallaButtonClicked(){

        this.vistaConfiguracion.setVisible(false);
        this.imgFMS.setVisible(true);
    }

    public void comenzarBatallaButtonClicked(){
        if(this.txtFieldMC1.getText() == "" && this.txtFieldMC2.getText() == ""){

        }

        FormatoFMS app = FormatoFMS.getInstance();
        app.iniciarBatallaNuevaEnPais(this.pais, this.txtFieldMC1.getText(), this.txtFieldMC2.getText());

        System.out.println("Pais de competencia: " + app.getPais());

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
                this.pais = ((Label) node).getText();
            }
        });


    }
}
