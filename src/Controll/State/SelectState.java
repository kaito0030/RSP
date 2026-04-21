package Controll.State;



import Controll.GameController;
import Controll.GameState;
import Model.Hand;
import Model.Result;

public class SelectState implements GameState {

    private GameController gc;

    public SelectState(GameController gc) {
        this.gc = gc;
    }

    @Override
    public void enter() {
    		if(!gc.tieFlag) {
    			gc.select.setMessage("じゃんけん");
    		}else {
    			gc.select.setMessage("あいこでしょ");
    			gc.tieFlag=false;
    		}
        
        gc.frame.showScreen("SELECT");

        gc.select.setHandListener(player -> {

            Hand cpu = gc.model.getCpuHand();
            Result r = gc.model.judge(player, cpu);

            if (r == Result.DRAW) {
                gc.result.setResultText("あいこ");
                gc.tieFlag=true;
            }else {
            		if (r == Result.WIN) {
            			gc.win++;
            			gc.result.setResultText("<html><font color=#000055>勝ち<html>");
            		}else {
            			gc.lose++;
            			gc.result.setResultText("<html><font color=#550000>負け<html>");
	            }
            		gc.roundCount++;
            		gc.result.setScore(gc.win, gc.lose);
            }
            
            gc.result.setHands(player, cpu);
            

            new ResultState(gc).enter();
        });
    }
}
