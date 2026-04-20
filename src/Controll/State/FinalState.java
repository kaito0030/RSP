package Controll.State;


import Controll.GameController;
import Controll.GameState;

public class FinalState implements GameState {

    private GameController gc;

    public FinalState(GameController gc) {
        this.gc = gc;
    }

    public void enter() {
        gc.fin.setFinal(gc.win, gc.lose);
        gc.frame.showScreen("FINAL");
    }
}
