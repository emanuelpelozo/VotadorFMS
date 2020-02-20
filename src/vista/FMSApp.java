package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FMSApp extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/vista/vistaPrincipal.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/vista/vistaVotacion.fxml"));

        primaryStage.setTitle("Formato FMS");

        primaryStage.setScene(new Scene(root));



//        primaryStage.initStyle(StageStyle.);
        primaryStage.show();
        primaryStage.sizeToScene();

        root.requestFocus();


    }
}
