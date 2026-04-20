package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ContinuePanel extends BasePanel {

    private JButton yes,no;

    @Override
    protected void initialize(){

        JLabel l=new JLabel("続けますか？",SwingConstants.CENTER);
        l.setBounds(300,200,200,50);
        add(l);

        yes=new JButton("はい");
        no=new JButton("いいえ");

        yes.setBounds(250,350,100,50);
        no.setBounds(450,350,100,50);

        add(yes); add(no);
    }

    public void setYesListener(Runnable r){
        yes.addActionListener(e->r.run());
    }

    public void setNoListener(Runnable r){
        no.addActionListener(e->r.run());
    }
}