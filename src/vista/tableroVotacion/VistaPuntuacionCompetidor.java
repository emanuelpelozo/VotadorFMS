package vista.tableroVotacion;

import controlador.BonificacionActionEvent;
import controlador.CasilleroEventHandler;
import controlador.VistaPuntuacionCompetidorEventHandler;
import controlador.VistaPuntuacionCompetidorEventHandlerMouse;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.Batalla.FabricaRounds;

public class VistaPuntuacionCompetidor extends HBox {

    private Label nombreCompetidor;
    private HBox casillasPrincipales;
    private HBox casillasEspeciales;
    private CasilleroAcumulador puntajeAcumulado;
    private String nombreRound;

    public VistaPuntuacionCompetidor(String nombreCompetidor, String nombreRound){

        this.nombreRound = nombreRound;
        this.nombreCompetidor = new Label(nombreCompetidor);
        this.casillasEspeciales = new HBox();
        this.casillasPrincipales = new HBox();
        this.puntajeAcumulado = new CasilleroAcumulador(nombreCompetidor, "Total");
        this.inicializar();
    }

    private void inicializar() {
        this.getChildren().add(nombreCompetidor);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        this.setOnKeyReleased(new VistaPuntuacionCompetidorEventHandler());

    }

    public void inicializarParaCantRounds(int cantRounds, int nroCompetidor) {
        String nombreCompetidor = this.nombreCompetidor.getText();

        this.casillasPrincipales.setSpacing(5);
        ObservableList<Node> children = this.casillasPrincipales.getChildren();

        for( int i = 1; i<= cantRounds; i++){

            String nroPatron = Integer.toString(i);
            Casillero casillero = new Casillero(Integer.toString(i));
            if(this.correspondeBonificacion(nombreRound, nroCompetidor)) {
                casillero.habilitarBonificacion();
                casillero.setOnActionParaBonificacion(new
                        BonificacionActionEvent(nroPatron, nombreCompetidor, this.nombreRound));
            }


            //probar con pasar el event handler al textfield por parametro de casillero
            casillero.setOnKeyReleased(new
                    CasilleroEventHandler(nroPatron,nombreCompetidor, this.nombreRound));

            children.add(casillero);
        }
        this.getChildren().add(this.casillasPrincipales);
        this.inicializarCasillasEspeciales();
    }

    private boolean correspondeBonificacion(String nombreRound, int nroCompetidor){
        if (nombreRound == FabricaRounds.PERSONAJES) return true;

        if(nombreRound.contains("Libre") && nroCompetidor == 2) return true;

        return false;
    }


    private void inicializarCasillasEspeciales(){
        String nombreCompetidor = this.nombreCompetidor.getText();
        this.casillasEspeciales.setSpacing(5);

        ObservableList<Node> children = this.casillasEspeciales.getChildren();
        Casillero flow = new Casillero("Flow");

        flow.setOnKeyReleased(new
                CasilleroEventHandler("Flow",nombreCompetidor, this.nombreRound));

        Casillero skill = new Casillero("Skill");
        skill.setOnKeyReleased(new
                CasilleroEventHandler("Skill",nombreCompetidor, this.nombreRound));

        Casillero ptaEscena = new Casillero("P.esc");
        ptaEscena.setOnKeyReleased(new
                CasilleroEventHandler("P.esc",nombreCompetidor, this.nombreRound));

        this.getChildren().addAll(flow,skill,ptaEscena, this.puntajeAcumulado);
    }

    public String getCompetidor(){
        return this.nombreCompetidor.getText();
    }


    public void setPuntaje(int puntaje) {
        this.puntajeAcumulado.setPuntaje(puntaje);
    }


}
