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

        gc.select.setMessage("じゃんけん");
        gc.frame.showScreen("SELECT");

        gc.select.setHandListener(player -> {

            Hand cpu = gc.model.getCpuHand();
            Result r = gc.model.judge(player, cpu);

            if (r == Result.DRAW) {
                gc.select.setMessage("あいこでしょ");
                return;
            }

            if (r == Result.WIN) gc.win++;
            else gc.lose++;

            gc.roundCount++;

            gc.result.setHands(player, cpu);

            if (r == Result.WIN)
                gc.result.setResultText("勝ち");
            else
                gc.result.setResultText("負け");

            gc.result.setScore(gc.win, gc.lose);

            new ResultState(gc).enter();
        });
    }
}
