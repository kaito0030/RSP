package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import View.Button.SquareButton;

public class ContinuePanel extends BasePanel {

    private SquareButton yes,no;

    @Override
    protected void initialize(){

        JLabel l=new JLabel("続けるのか？",SwingConstants.CENTER);
        l.setFont(new Font("HG行書体",Font.BOLD,100));
        l.setBounds(75,200,650,125);
        add(l);

        yes=new SquareButton("はい");
        yes.setFont(new Font("HG行書体",Font.BOLD,30));
        no=new SquareButton("いいえ");
        no.setFont(new Font("HG行書体",Font.BOLD,30));

        yes.setBounds(150,400,200,50);
        no.setBounds(450,400,200,50);

        add(yes); add(no);
    }

    public void setYesListener(Runnable r){
        yes.addActionListener(e->r.run());
    }

    public void setNoListener(Runnable r){
        no.addActionListener(e->r.run());
    }
}