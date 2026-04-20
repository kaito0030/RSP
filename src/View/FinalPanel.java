package View;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FinalPanel extends BasePanel {

    private JLabel result;
    private JLabel score;

    @Override
    protected void initialize(){
        result=new JLabel("",SwingConstants.CENTER);
        result.setBounds(250,250,300,50);
        add(result);
        score=new JLabel("",SwingConstants.CENTER);
        score.setBounds(250,150,300,50);
        add(score);
    }

    public void setFinal(int w,int l){
        String r=(w>l)?"勝利":(w<l)?"敗北":"引き分け";
        result.setText(r);
        score.setText(w+"-"+l);
    }
}