package vista.tableroVotacion;

import com.jfoenix.controls.JFXTabPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import modelo.Batalla.FabricaRounds;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaRoundParaPuntuacion;

import java.util.function.Consumer;

public class VistaTabPaneRounds extends JFXTabPane {

    private FormatoFMS app;
    private Tab tabPalabras;
    private Tab tabTematicas;
    private Tab tabPersonajes;
    private Tab tabLibre;
    private Tab tabDeluxe;

    public VistaTabPaneRounds(FormatoFMS app){

        this.app = app ;
        this.iniciarTabs();

    }

    private void iniciarTabs() {

        this.tabPalabras = new Tab();
        HBox contenedorRound = new HBox();
        this.iniciarTabPalabras(contenedorRound, tabPalabras);


        this.tabTematicas = new Tab();
        contenedorRound = new HBox();
        this.iniciarTabTematica(contenedorRound, tabTematicas);

        this.tabPersonajes = new Tab();
        contenedorRound = new HBox();
        this.iniciarTabPersonajes(contenedorRound, tabPersonajes);

        this.tabLibre = new Tab();
        contenedorRound = new HBox();
        this.iniciarTabLibre(contenedorRound, tabLibre);

        this.tabDeluxe = new Tab();
        contenedorRound = new HBox();
        this.iniciarTabDeluxe(contenedorRound, tabDeluxe);

    }


    private void agregarVistaEnContenedorRound(String nombreRound, int cantEntradas, HBox contenedorRound){

        contenedorRound.setSpacing(20);

        VistaRoundParaPuntuacion vista = new VistaRoundParaPuntuacion(nombreRound,
                app.getCompetidorQueAtaca(), app.getCompetidorQueResponde());

        vista.inciarParaCantidadDeRounds(cantEntradas);

        contenedorRound.getChildren().add(vista);

    }

    private void iniciarTabPalabras(HBox contenedorRound, Tab tab) {

        String textoTab = FabricaRounds.EASY_MODE +"/"+ FabricaRounds.HARD_MODE;
        tab.setText(textoTab);

        app.setEasyMode();
        agregarVistaEnContenedorRound(FabricaRounds.EASY_MODE, FabricaRounds.ENTRADAS_EMODE, contenedorRound);

        app.setHardMode();
        agregarVistaEnContenedorRound(FabricaRounds.HARD_MODE, FabricaRounds.ENTRADAS_HMODE, contenedorRound);

        tab.setContent(contenedorRound);
        this.getTabs().add(tab);

    }

    private void iniciarTabTematica(HBox contenedorRound, Tab tab) {

        String textoTab = "Tematicas";
        tab.setText(textoTab);

        app.setTematicaIda();
        agregarVistaEnContenedorRound(FabricaRounds.TEMATICA_IDA, FabricaRounds.ENTRADAS_TEMATICA, contenedorRound);

        app.setTematicaVuelta();
        agregarVistaEnContenedorRound(FabricaRounds.TEMATICA_VTA, FabricaRounds.ENTRADAS_TEMATICA, contenedorRound);

        tab.setContent(contenedorRound);
        this.getTabs().add(tab);

    }


    private void iniciarTabPersonajes(HBox contenedorRound, Tab tab) {

        String textoTab = "Personajes";
        tab.setText(textoTab);

        app.setPersonajes();
        agregarVistaEnContenedorRound(FabricaRounds.PERSONAJES, FabricaRounds.ENTRADAS_PJES, contenedorRound);

        tab.setContent(contenedorRound);
        this.getTabs().add(tab);

    }


    private void iniciarTabLibre(HBox contenedorRound, Tab tab) {

        String textoTab = "Libre";
        tab.setText(textoTab);

        app.setTematicaIda();
        agregarVistaEnContenedorRound(FabricaRounds.LIBRE_IDA, FabricaRounds.ENTRADAS_LIBRE, contenedorRound);

        app.setTematicaVuelta();
        agregarVistaEnContenedorRound(FabricaRounds.LIBRE_VTA, FabricaRounds.ENTRADAS_LIBRE, contenedorRound);

        tab.setContent(contenedorRound);
        this.getTabs().add(tab);

    }

    private void iniciarTabDeluxe(HBox contenedorRound, Tab tab) {

        String textoTab = "Deluxe";
        tab.setText(textoTab);

        app.setDeluxe();
        agregarVistaEnContenedorRound(FabricaRounds.DELUXE, FabricaRounds.ENTRADAS_DELUXE, contenedorRound);

        tab.setContent(contenedorRound);
        this.getTabs().add(tab);

    }

//    public void actualizarPuntajesTabActual(int puntaje1, int puntaje2){
//        Tab tabActual = this.getSelectionModel().getSelectedItem();
//        HBox contenedorRound = (HBox) tabActual.getContent();
//
//        VistaRoundParaPuntuacion contenedorRound.getChildren().get(0);
//    }

}
