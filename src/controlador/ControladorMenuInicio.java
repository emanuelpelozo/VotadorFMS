package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;

public class ControladorMenuInicio {

    private String competencia;

    @FXML
    private ImageView imagenCompetencia;


    @FXML
    public void establecerImagenCompetencia(MouseEvent mouseEvent) {
        Text texto = (Text) mouseEvent.getSource();
        this.competencia = texto.getText();
        File file = new File(this.construirPathLogo());
        Image image = new Image(file.toURI().toString());
        this.imagenCompetencia.setImage(image);
    }

    @FXML
    public void iluminarTexto(MouseEvent mouseEvent){
        Text texto = (Text) mouseEvent.getSource();
        texto.setFill(Color.CORAL);
        texto.setEffect(new Glow());
    }

    @FXML
    public void reestablecerTexto(MouseEvent mouseEvent){
        Text texto = (Text) mouseEvent.getSource();
        texto.setFill(Color.WHITE);
        texto.setEffect(null);
    }


    private String construirPathLogo(){
        String path ="resources/" + this.competencia.toLowerCase() + "Logo.png";
        return path;
    }
}
