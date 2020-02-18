package vista;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AlertaBatalla extends Alert {


    public AlertaBatalla(AlertType alertType) {
        super(alertType);
        this.configurarAlerta();
    }

    private void configurarAlerta() {
        ImageView image =new ImageView(this.getClass().
                getResource("../resources/images/microfonos.png").toString());
        image.setFitHeight(50);
        image.setFitWidth(50);
        DialogPane dialogPane = this.getDialogPane();

        dialogPane.getStylesheets().add(
                getClass().getResource("myDialogs.css").toExternalForm());

        dialogPane.setGraphic(image);
    }
}
