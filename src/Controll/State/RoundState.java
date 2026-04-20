package Controll.State;


import javax.swing.Timer;

import Controll.GameController;
import Controll.GameState;

public class RoundState implements GameState {

    private GameController gc;

    public RoundState(GameController gc) {
        this.gc = gc;
    }

    @Override
    public void enter() {

        gc.round.update(gc.roundCount + 1, gc.win, gc.lose);
        gc.frame.showScreen("ROUND");

        new Timer(1500, e -> {
            ((Timer)e.getSource()).stop();
            new SelectState(gc).enter();
        }).start();
    }
}
