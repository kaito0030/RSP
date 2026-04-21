package Controll.State;



import javax.swing.Timer;

import Controll.GameController;
import Controll.GameState;

public class ResultState implements GameState {

    private GameController gc;

    public ResultState(GameController gc) {
        this.gc = gc;
    }

    public void enter() {
        gc.frame.showScreen("RESULT");
        if(!gc.tieFlag) {
        		gc.result.addNextButton();
	        gc.result.setNextListener(() -> {
	            if (gc.roundCount % 5 == 0 && gc.roundCount<50)
	                new ContinueState(gc).enter();
	            else
	                new RoundState(gc).enter();
	        });
        }else {
        	gc.result.removeNextButton();
            new Timer(1500, e -> {
                ((Timer)e.getSource()).stop();
                new SelectState(gc).enter();
            }).start();
        }
    }
}