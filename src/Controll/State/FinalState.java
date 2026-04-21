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
        
        gc.fin.setResetListener(() ->{
        		gc.win=0;
        		gc.lose=0;
        		gc.roundCount=0;
        		new TitleState(gc).enter();
        }
        		
        	);

	    gc.fin.setExitListener(() ->{
	    		gc.frame.setVisible(false);
	    		System.exit(0);
	    }
	        
	    );
    }
}
