package Controll;


import Model.JankenModel;
import View.ContinuePanel;
import View.FinalPanel;
import View.MainFrame;
import View.ResultPanel;
import View.RoundPanel;
import View.SelectPanel;
import View.TitlePanel;

public class GameController {
	public boolean tieFlag;
    public MainFrame frame=new MainFrame();

    public TitlePanel title=new TitlePanel();
    public RoundPanel round=new RoundPanel();
    public SelectPanel select=new SelectPanel();
    public ResultPanel result=new ResultPanel();
    public ContinuePanel cont=new ContinuePanel();
    public FinalPanel fin=new FinalPanel();
    public JankenModel model=new JankenModel();
    
    public String pName;
    public String eName="敵";
    
    public int win=0,lose=0,roundCount=0;

    public GameController(){
    		tieFlag=false;
        frame.addScreen(title,"TITLE");
        frame.addScreen(round,"ROUND");
        frame.addScreen(select,"SELECT");
        frame.addScreen(result,"RESULT");
        frame.addScreen(cont,"CONTINUE");
        frame.addScreen(fin,"FINAL");

        new Controll.State.TitleState(this).enter();

        frame.setVisible(true);
    }
}