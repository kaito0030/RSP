package Controll.State;



import Controll.GameController;
import Controll.GameState;

public class ContinueState implements GameState {

    private GameController gc;

    public ContinueState(GameController gc) {
        this.gc = gc;
    }

    public void enter() {
        gc.frame.showScreen("CONTINUE");

        gc.cont.setYesListener(() ->
            new RoundState(gc).enter()
        );

        gc.cont.setNoListener(() ->
            new FinalState(gc).enter()
        );
    }
}