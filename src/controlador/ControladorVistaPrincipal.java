package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.junit.FixMethodOrder;

public class ControladorVistaPrincipal {
    private Text textNuevaBatalla;
    @FXML
    private Label labelTitulo;


    private void iniciarNuevaBatalla(){
        
    }

    @FXML
    public void cambiarFuente(){
        this.labelTitulo.setFont(Font.font("TRON",35));
    }

}
