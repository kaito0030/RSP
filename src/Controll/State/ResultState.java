package Controll.State;



import Controll.GameController;
import Controll.GameState;

public class ResultState implements GameState {

    private GameController gc;

    public ResultState(GameController gc) {
        this.gc = gc;
    }

    public void enter() {
        gc.frame.showScreen("RESULT");

        gc.result.setNextListener(() -> {
            if (gc.roundCount % 5 == 0)
                new ContinueState(gc).enter();
            else
                new RoundState(gc).enter();
        });
    }
}