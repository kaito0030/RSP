package Controll.State;



import Controll.GameController;
import Controll.GameState;

public class TitleState implements GameState {

    private GameController gc;

    public TitleState(GameController gc) {
        this.gc = gc;
    }

    @Override
    public void enter() {

        gc.frame.showScreen("TITLE");
        
        gc.title.setStartListener(() ->{
        		gc.result.setName(gc.title.getText());
            new RoundState(gc).enter();
        }
        );
    }
}
